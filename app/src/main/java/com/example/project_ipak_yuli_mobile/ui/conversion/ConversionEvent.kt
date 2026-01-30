package com.example.project_ipak_yuli_mobile.ui.conversion

sealed class ConversionEvent {
    data class ShowError(val message: String): ConversionEvent()
}