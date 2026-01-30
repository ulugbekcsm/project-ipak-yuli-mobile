package com.example.project_ipak_yuli_mobile.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute: NavKey {

    @Serializable
    data object Main : AppRoute
    @Serializable
    data object Cards : AppRoute
}

@Serializable
sealed interface MainRoute: NavKey {

    @Serializable
    data object Home : MainRoute
    @Serializable
    data object Services : MainRoute
    @Serializable
    data object Payments : MainRoute
    @Serializable
    data object Conversion : MainRoute
    @Serializable
    data object More : MainRoute
}