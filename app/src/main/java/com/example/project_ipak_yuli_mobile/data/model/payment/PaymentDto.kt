package com.example.project_ipak_yuli_mobile.data.model.payment

import com.google.gson.annotations.SerializedName

data class PaymentDto(
    val id: String,
    val name: String,
    @SerializedName("display_order")
    val displayOrder: String,
    val color: String,
    @SerializedName("icon_name")
    val iconName: String,
    @SerializedName("icon_link")
    val iconLink: String,
    @SerializedName("icon_resource")
    val iconResource: PaymentIconResourceDto
)