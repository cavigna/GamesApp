package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("store")
    var store: StoreX = StoreX(),
    @SerializedName("url")
    var url: String = ""
)