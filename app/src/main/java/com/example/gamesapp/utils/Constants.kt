package com.example.gamesapp.utils

import com.example.gamesapp.BuildConfig
import com.example.gamesapp.R
import com.example.gamesapp.models.JuegoPrueba


object Constants {

    val BASE_URL = "https://api.rawg.io/api/"

    const val API_KEY = BuildConfig.API_KEY

    val juegos = listOf(
        JuegoPrueba(), JuegoPrueba(name = "FarCry 6", date = "10-07-2021", image = R.drawable.farcry),
        JuegoPrueba(name = "Halo Infinite", image = R.drawable.halo),
        JuegoPrueba(
            "Death Loop",
            "14-09-2021",
            image = R.drawable.deathloop,
            plataform = listOf("PC", "XBOX", "PS")
        ),
        JuegoPrueba("Stray", "03-02-2022", image = R.drawable.stray),
        JuegoPrueba(),
        JuegoPrueba(), JuegoPrueba(), JuegoPrueba(),
        JuegoPrueba(), JuegoPrueba(), JuegoPrueba(),

        )
}

//https://api.rawg.io/api/games?key=9cf56c460a374856bafaf80bd9d2d561&dates=2021-08-01,2021-12-31