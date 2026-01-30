package com.example.project_ipak_yuli_mobile.domain.model.transferswap

import com.example.project_ipak_yuli_mobile.domain.model.card.Currency

enum class TransferRole(
    val currency: Currency,
    val senderTitle: String,
    val receiverTitle: String
) {
    FROM_UZS_TO_USD(
        currency = Currency.UZS,
        senderTitle = "TRANSFER FROM",
        receiverTitle = "TRANSFER TO"
    ),

    FROM_USD_TO_UZS(
        currency = Currency.USD,
        senderTitle = "SELL FROM",
        receiverTitle = "TRANSFER TO"
    )
}