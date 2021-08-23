package com.example.gamesapp.models

import android.graphics.drawable.BitmapDrawable
import com.example.gamesapp.R

data class JuegoPrueba(
    val name: String = "Senua's Saga: Hellblade II",
    val date: String = "31-12-2021",
    val plataform: List<String> = listOf("PC", "XBOX"),
    val image :Int = R.drawable.senuas
)