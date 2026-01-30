package com.example.project_ipak_yuli_mobile.ui.services

import com.example.project_ipak_yuli_mobile.domain.model.service.Service

data class ServicesUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val services: List<Service> = emptyList()
)