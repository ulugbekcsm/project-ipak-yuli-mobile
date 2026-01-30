package com.example.project_ipak_yuli_mobile.domain.model.payment

data class PaymentIconResource(
    val id: String,
    val name: String,
    val type: String,
    val links: PaymentLinks
)