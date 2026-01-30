package com.example.project_ipak_yuli_mobile.domain.model.card

enum class CardPattern(
    val value: String
) {
    UZCARD("uzcard"),
    HUMO("humo"),
    HUMOVIRTUAL("humovirtual"),
    VISASUM("visasum"),
    VISASTART("visastart"),
    VISAINFINITE("visainfinite"),
    VISAPLATINUMLIGHT("visaplatinumlight"),
    VISAPLATINUMBLACK("visaplatinumblack"),
    VISAVIRTUAL("visavirtual"),
    VISAELECTRON("visaelectron"),
    MC("mastercard"),
    MCARDVIRTUAL("mcardvirtual"),
    UPCLASSIC("upclassic"),
    UPGOLD("upgold"),
    UNKNOWN("unknown")
}