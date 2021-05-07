package com.example.codelab2_3.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Affirmation(
        @StringRes val stringResourceId: Int,
        @DrawableRes val imageResourceId: Int
)