package com.example.gamesapp.repository

import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.network.GamesApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class GamesRepository @Inject constructor(
    private val api: GamesApi
){
    suspend fun upcomingGames(): GamesUpcoming{
        return api.upcomingGames()
    }
}