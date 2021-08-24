package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("slug")
    var slug: String = ""
)