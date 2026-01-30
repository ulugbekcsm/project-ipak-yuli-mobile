package com.example.project_ipak_yuli_mobile.domain.model.balance

import com.example.project_ipak_yuli_mobile.domain.model.card.Currency

data class Balance(
    val currency: Currency,
    val amount: String
)