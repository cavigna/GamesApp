package com.example.gamesapp.repository

import android.util.Log
import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.network.GamesApi
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class GamesRepository @Inject constructor(
    private val api: GamesApi
){
    suspend fun upcomingGames(): GamesUpcoming{
        return api.upcomingGames()
    }

    suspend fun searchGame(queryGame:String):GamesUpcoming{
        return api.searchGame(querySearch = queryGame)
    }

    suspend fun detailGameResponse(slug:String): GameDetail {
        Log.v("llamada", api.detailGameResponse(slug).toString())
        return api.detailGameResponse(slug)
    }

    suspend fun bestGameOfYear():GamesUpcoming{
        return api.bestGamesOfYear()
    }

    suspend fun prueba(slug: String):Response<GameDetail>{
        return api.prueba(slug)
    }


}