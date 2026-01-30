package com.example.project_ipak_yuli_mobile.ui.cards

import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard

data class CardsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val userCards: List<UserCard> = emptyList(),
    val cardTabs: List<CardTab> = CardTab.categories,

    val isUserCardsCompactMode: Boolean = false,
    val isCardActionSheetVisible: Boolean = false,
    val isUserCardsRefreshing: Boolean = false,
)