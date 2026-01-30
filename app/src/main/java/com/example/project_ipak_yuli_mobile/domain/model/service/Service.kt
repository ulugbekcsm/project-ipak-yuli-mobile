package com.example.project_ipak_yuli_mobile.domain.model.service

data class Service(
    val key: String,
    val type: String,
    val title: String,
    val isEnabled: Boolean,
    val isOn: Boolean,
    val icon: ServiceIcon
)