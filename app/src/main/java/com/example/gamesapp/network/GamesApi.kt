package com.example.gamesapp.network

import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApi {

    @GET("games?key=${API_KEY}&dates=2021-08-01,2021-12-31")
    suspend fun upcomingGames(): GamesUpcoming

    @GET("games/{slug}?key=${API_KEY}")
    suspend fun detailGameResponse(@Path("slug") slug:String): GameDetail

}