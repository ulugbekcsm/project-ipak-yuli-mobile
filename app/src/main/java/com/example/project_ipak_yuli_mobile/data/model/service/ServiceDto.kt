package com.example.project_ipak_yuli_mobile.data.model.service

import com.google.gson.annotations.SerializedName

data class ServiceDto(
    val key: String,
    val type: String,
    val title: String,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    @SerializedName("is_on")
    val isOn: Boolean,
    val icon: ServiceIconDto
)