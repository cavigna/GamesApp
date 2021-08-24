package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class Publisher(
    @SerializedName("games_count")
    var gamesCount: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image_background")
    var imageBackground: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("slug")
    var slug: String = ""
)