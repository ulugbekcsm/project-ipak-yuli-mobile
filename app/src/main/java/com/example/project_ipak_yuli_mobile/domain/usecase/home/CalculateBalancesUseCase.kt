package com.example.project_ipak_yuli_mobile.domain.usecase.home

import com.example.project_ipak_yuli_mobile.domain.model.balance.Balance
import com.example.project_ipak_yuli_mobile.domain.model.card.Currency
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import javax.inject.Inject

class CalculateBalancesUseCase @Inject constructor() {
    operator fun invoke(cards: List<UserCard>) : List<Balance> {
        val uzsBalance = cards.filter { it.currency == Currency.UZS.display }.sumOf { it.balance }
        val usdBalance = cards.filter { it.currency == Currency.USD.display }.sumOf { it.balance }
        return listOf(
            Balance(Currency.UZS, uzsBalance.toString()),
            Balance(Currency.USD, usdBalance.toString())
        )
    }
}