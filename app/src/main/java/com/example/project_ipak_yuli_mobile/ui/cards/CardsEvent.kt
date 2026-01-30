package com.example.project_ipak_yuli_mobile.ui.cards

sealed class CardsEvent {
    data class ShowError(val message: String): CardsEvent()
}