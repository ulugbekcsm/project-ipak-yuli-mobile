package com.example.project_ipak_yuli_mobile.ui.payments

sealed class PaymentsEvent {
    data class ShowError(val message: String): PaymentsEvent()
}