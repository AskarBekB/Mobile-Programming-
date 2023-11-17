package com.example.superheroes.data

import com.example.superheroes.R
import com.example.superheroes.model.Hero

object DataSource {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descriptRes = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            descriptRes = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            descriptRes = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            descriptRes = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            descriptRes = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            descriptRes = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}