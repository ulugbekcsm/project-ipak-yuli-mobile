package com.example.project_ipak_yuli_mobile.ui.payments

import com.example.project_ipak_yuli_mobile.domain.model.payment.Payment

data class PaymentsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val payments: List<Payment> = emptyList()
)