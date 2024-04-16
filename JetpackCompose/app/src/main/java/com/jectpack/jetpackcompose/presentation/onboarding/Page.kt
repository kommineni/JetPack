package com.jectpack.jetpackcompose.presentation.onboarding

import androidx.annotation.DrawableRes
import com.jectpack.jetpackcompose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Title1",
        "The dummy screen with the dummy description",
        R.drawable.onboarding1
    ),
    Page(
        "Title2",
        "The dummy screen3 with the dummy description",
        R.drawable.onboarding2
    ),
    Page(
        "Title3",
        "The dummy screen3 with the dummy description",
        R.drawable.onboarding3
    )
)