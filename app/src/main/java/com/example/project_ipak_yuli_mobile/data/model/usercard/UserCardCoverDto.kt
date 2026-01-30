package com.example.project_ipak_yuli_mobile.data.model.usercard

import com.google.gson.annotations.SerializedName

data class UserCardCoverDto(
    @SerializedName("cover")
    val cover: String,

    @SerializedName("cover_mini")
    val coverMini: String,

    @SerializedName("logo_image")
    val logoImage: String,

    @SerializedName("logo_image_mini")
    val logoImageMini: String
)