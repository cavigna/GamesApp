package com.example.gamesapp.models.upcoming


import com.google.gson.annotations.SerializedName

data class PlatformXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)