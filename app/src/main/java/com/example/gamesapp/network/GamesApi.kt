package com.example.gamesapp.network

import com.example.gamesapp.BuildConfig
import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.utils.Constants.API_KEY
import retrofit2.http.GET

interface GamesApi {
companion object{
  //  val API_KEY = BuildConfig.API_KEY
}


    @GET("games?key=${API_KEY}&dates=2021-08-01,2021-12-31")
    suspend fun upcomingGames(): GamesUpcoming
}