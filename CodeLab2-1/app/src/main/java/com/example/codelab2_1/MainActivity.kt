package com.example.codelab2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codelab2_1.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    // setBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        // getCostText
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        // get tipOptions（radius group）'s items
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        //返回當前預設語言環境的預設數值格式。
        //getCurrencyInstance()返回當前預設語言環境的通用格式
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        // setText
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}