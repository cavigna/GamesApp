package com.example.gamesapp.utils

import androidx.compose.ui.text.toLowerCase
import com.example.gamesapp.R
import com.example.gamesapp.R.drawable
import java.util.*

fun iconGamePlataform(plataform:String):Int{
    return when(plataform){
        "pc"-> drawable.ic_windows_logo_white
        "xbox" -> drawable.ic_xbox_logo_white
        "playstation"-> drawable.ic_ps_logo
        else -> drawable.ic_launcher_foreground
    }
}

//plataform.toLowerCase(Locale.ROOT)