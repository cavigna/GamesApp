package com.example.gamesapp.network

import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApi {

    /*
    https://api.rawg.io/api/games?dates=2021-01-01,2021-12-31&ordering=-rating&key=${API_KEY}
    GET https://api.rawg.io/api/games?dates=2001-01-01,2001-12-31&ordering=-rating
     */

    @GET("games?key=${API_KEY}&dates=2021-08-01,2021-12-31")
    suspend fun upcomingGames(): GamesUpcoming

    @GET("games")
    suspend fun bestGamesOfYear(
        @Query("dates") dates:String = "2021-01-01,2021-12-31",
        @Query("ordering") ordering:String = "-rating",
        @Query("page_size") page_size:String = "25",
        @Query("key") apiKey:String = API_KEY,

    ): GamesUpcoming

    @GET("games")
    suspend fun searchGame(
        @Query("key") apiKey:String = API_KEY,
        @Query("search") querySearch : String
    ): GamesUpcoming


    @GET("games/{slug}?key=${API_KEY}")
    suspend fun detailGameResponse(@Path("slug") slug: String): GameDetail


    @GET("games/{slug}?key=${API_KEY}")
    suspend fun prueba(@Path("slug") slug: String): Response<GameDetail>
}