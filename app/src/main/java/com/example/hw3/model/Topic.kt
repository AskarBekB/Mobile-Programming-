package com.example.hw3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val numCourse: Int,
    @DrawableRes val imageResourceId: Int,
)
