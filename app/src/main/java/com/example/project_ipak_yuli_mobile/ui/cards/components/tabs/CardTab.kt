package com.example.project_ipak_yuli_mobile.ui.cards.components.tabs

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard

data class CardTab(
    val name: String,
    val index: Int,
    val isSelected: Boolean,
    var cardList: List<UserCard>
) {
    companion object {
        val categories = listOf(
            CardTab("All", 0, true, emptyList()),
            CardTab("UZ Sum", 1, false, emptyList()),
            CardTab("US Dollar", 2, false, emptyList()),
            CardTab("Wallet and others", 3, false, emptyList())
        )
    }
}