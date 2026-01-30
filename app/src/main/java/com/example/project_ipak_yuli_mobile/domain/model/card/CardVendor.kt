package com.example.project_ipak_yuli_mobile.domain.model.card

enum class CardVendor(
    val value: String,
    val display: String
) {
    UZCARD("uzcard", "UzCard"),
    HUMO("humo", "Humo"),
    VISA("visa", "Visa"),
    MC("mc", "MasterCard"),
    CUP("cup", "UnionPay"),
    UNKNOWN_VENDOR("unknownvendor", "Unknown Vendor")
}