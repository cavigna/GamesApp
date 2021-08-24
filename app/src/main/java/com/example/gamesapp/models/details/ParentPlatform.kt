package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    var platform: Platform = Platform()
)