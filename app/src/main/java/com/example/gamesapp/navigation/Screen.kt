package com.example.gamesapp.navigation

sealed class Screen(val route:String){

    object MainScreen : Screen(route = "main_screen")
    object DetailScreen : Screen(route = "detail_screen")

}
