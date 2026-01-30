package com.example.project_ipak_yuli_mobile.core.ui.mapper

import com.example.project_ipak_yuli_mobile.domain.model.card.CardPattern
import com.example.project_ipak_yuli_mobile.R

fun CardPattern.iconRes(): Int {
    return when (this) {
        CardPattern.UZCARD -> R.drawable.svg_logo_uzcard_white_bg
        CardPattern.HUMO -> R.drawable.svg_logo_humo
        CardPattern.HUMOVIRTUAL -> R.drawable.svg_logo_humo_virtual
        CardPattern.VISASUM -> R.drawable.svg_logo_visa_sum
        CardPattern.VISASTART -> R.drawable.svg_logo_visa_start
        CardPattern.VISAINFINITE -> R.drawable.svg_logo_visa_infinite
        CardPattern.VISAPLATINUMLIGHT -> R.drawable.svg_logo_visa_platinum_light
        CardPattern.VISAPLATINUMBLACK -> R.drawable.svg_logo_visa_platinum_black
        CardPattern.VISAVIRTUAL -> R.drawable.svg_logo_visa_virtual
        CardPattern.VISAELECTRON -> R.drawable.svg_logo_visa_electron
        CardPattern.MC -> R.drawable.svg_logo_mastercard_for_big
        CardPattern.MCARDVIRTUAL -> R.drawable.svg_logo_mastercard_virtual_for_big
        CardPattern.UPCLASSIC -> R.drawable.svg_logo_union_pay
        CardPattern.UPGOLD -> R.drawable.svg_logo_union_pay
        else -> R.drawable.icon_x_close
    }
}