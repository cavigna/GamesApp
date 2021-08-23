package com.example.gamesapp.models.upcoming


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    val platform: Platform
)