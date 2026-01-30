package com.example.project_ipak_yuli_mobile.ui.services

sealed class ServicesEvent {
    data class ShowError(val message: String): ServicesEvent()
}