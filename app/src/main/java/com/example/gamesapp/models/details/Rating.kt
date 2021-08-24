package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    var count: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("percent")
    var percent: Double = 0.0,
    @SerializedName("title")
    var title: String = ""
)