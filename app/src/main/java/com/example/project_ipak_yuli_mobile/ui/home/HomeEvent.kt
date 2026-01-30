package com.example.project_ipak_yuli_mobile.ui.home

sealed class HomeEvent {
    data class ShowError(val message: String): HomeEvent()
}