package com.example.project_ipak_yuli_mobile.ui.more

sealed class MoreEvent {
    data class ShowError(val message: String): MoreEvent()
}