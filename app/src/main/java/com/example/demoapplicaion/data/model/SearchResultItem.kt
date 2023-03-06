package com.example.demoapplicaion.data.model


import com.google.gson.annotations.SerializedName

data class SearchResultItem(
    @SerializedName("lfs")
    var lfs: List<Lf>,
    @SerializedName("sf")
    var sf: String
)