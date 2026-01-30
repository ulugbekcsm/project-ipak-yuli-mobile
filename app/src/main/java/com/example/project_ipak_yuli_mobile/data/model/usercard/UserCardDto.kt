package com.example.project_ipak_yuli_mobile.data.model.usercard

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class UserCardDto(
    val id: String,
    val balance: BigDecimal,
    val state: String,
    @SerializedName("credit_limit")
    val creditLimit: Double?,
    val pan: String,
    val expire: String,
    val currency: String,
    @SerializedName("is_virtual")
    val isVirtual: Boolean,
    val type: String,
    @SerializedName("has_info")
    val hasInfo: Boolean,
    val pattern: String,
    val vendor: String,
    @SerializedName("is_main")
    val isMain: Boolean,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("is_owner")
    val isOwner: Boolean,
    val title: String,
    val account: String,
    val cover: UserCardCoverDto
)