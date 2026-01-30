package com.example.project_ipak_yuli_mobile.domain.model.payment

data class Payment(
    val id: String,
    val name: String,
    val displayOrder: String,
    val color: String,
    val iconName: String,
    val iconLink: String,
    val iconResource: PaymentIconResource
)