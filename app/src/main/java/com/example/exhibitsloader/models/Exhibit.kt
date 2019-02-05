package com.example.exhibitsloader.models

import com.google.gson.annotations.SerializedName

data class ExhibitonsList(@SerializedName("list") val list: MutableList<Exhibit>) {
    data class Exhibit(
        @SerializedName("title") val title: String,
        @SerializedName("images") val images: MutableList<String>
    )
}