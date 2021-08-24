package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class PlatformXX(
    @SerializedName("games_count")
    var gamesCount: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: Any = Any(),
    @SerializedName("image_background")
    var imageBackground: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("slug")
    var slug: String = "",
    @SerializedName("year_end")
    var yearEnd: Any = Any(),
    @SerializedName("year_start")
    var yearStart: Any = Any()
)