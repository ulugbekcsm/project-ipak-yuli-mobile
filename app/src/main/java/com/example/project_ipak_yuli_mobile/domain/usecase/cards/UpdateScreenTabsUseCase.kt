package com.example.project_ipak_yuli_mobile.domain.usecase.cards

import com.example.project_ipak_yuli_mobile.domain.model.card.Currency
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab
import javax.inject.Inject

class UpdateScreenTabsUseCase @Inject constructor() {
    operator fun invoke(cards: List<UserCard>, tabs: List<CardTab>): List<CardTab> {
        val uzs = cards.filter { it.currency == Currency.UZS.display }
        val usd = cards.filter { it.currency == Currency.USD.display }
        val others = cards.filter {
            it.currency != Currency.UZS.display && it.currency != Currency.USD.display
        }

        return tabs.map { tab ->
            when (tab.index) {
                0 -> tab.copy(cardList = cards)
                1 -> tab.copy(cardList = uzs)
                2 -> tab.copy(cardList = usd)
                else -> tab.copy(cardList = others)
            }
        }
    }
}