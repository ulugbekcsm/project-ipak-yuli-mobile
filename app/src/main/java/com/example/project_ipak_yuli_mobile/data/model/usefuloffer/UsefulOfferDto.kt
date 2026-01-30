package com.example.project_ipak_yuli_mobile.data.model.usefuloffer

import com.google.gson.annotations.SerializedName

data class UsefulOfferDto(
    val id: String,
    val title: String,
    val image: String,
    val link: String,
    @SerializedName("show_order")
    val showOrder: String,
    val state: String,
    val lang: String,
    val important: String
)