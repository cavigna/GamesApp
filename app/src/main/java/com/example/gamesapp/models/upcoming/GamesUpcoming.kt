package com.example.gamesapp.models.upcoming


import com.google.gson.annotations.SerializedName

data class GamesUpcoming(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val gamesLists: List<GamesList>,
    @SerializedName("user_platforms")
    val userPlatforms: Boolean
)