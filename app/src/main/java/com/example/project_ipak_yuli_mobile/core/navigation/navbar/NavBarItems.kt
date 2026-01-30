package com.example.project_ipak_yuli_mobile.core.navigation.navbar

import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.navigation.MainRoute

object NavBarItems {
    val items = listOf(
        NavBarItem(
            title = "Main",
            icon = R.drawable.icon_main,
            route = MainRoute.Home
        ),
        NavBarItem(
            title = "Services",
            icon = R.drawable.icon_services,
            route = MainRoute.Services
        ),
        NavBarItem(
            title = "Payments",
            icon = R.drawable.icon_payments,
            route = MainRoute.Payments
        ),
        NavBarItem(
            title = "Conversion",
            icon = R.drawable.icon_conversion,
            route = MainRoute.Conversion
        ),
        NavBarItem(
            title = "More",
            icon = R.drawable.icon_more,
            route = MainRoute.More
        )
    )
}