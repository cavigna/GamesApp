package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class PlatformX(
    @SerializedName("platform")
    var platform: PlatformXX = PlatformXX(),
    @SerializedName("released_at")
    var releasedAt: Any = Any(),
    @SerializedName("requirements")
    var requirements: Requirements = Requirements()
)