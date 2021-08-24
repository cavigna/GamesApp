package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class Requirements(
    @SerializedName("minimum")
    var minimum: String = ""
)