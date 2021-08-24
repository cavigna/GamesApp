package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class AddedByStatus(
    @SerializedName("beaten")
    var beaten: Int = 0,
    @SerializedName("dropped")
    var dropped: Int = 0,
    @SerializedName("owned")
    var owned: Int = 0,
    @SerializedName("playing")
    var playing: Int = 0,
    @SerializedName("toplay")
    var toplay: Int = 0,
    @SerializedName("yet")
    var yet: Int = 0
)