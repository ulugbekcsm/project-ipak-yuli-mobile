package com.example.project_ipak_yuli_mobile.domain.model.usercard

import com.example.project_ipak_yuli_mobile.domain.model.card.CardPattern
import java.math.BigDecimal

data class UserCard(
    val id: String,
    val balance: BigDecimal,
    val state: String,
    val creditLimit: Double?,
    val pan: String,
    val expire: String,
    val currency: String,
    val isVirtual: Boolean,
    val type: String,
    val hasInfo: Boolean,
    val pattern: String,
    val vendor: String,
    val isMain: Boolean,
    val isHidden: Boolean,
    val isOwner: Boolean,
    val title: String,
    val account: String,
    val cover: UserCardCover,
    val cardPattern: CardPattern,
    val canFlip: Boolean,
    var isFlipped: Boolean = false
)