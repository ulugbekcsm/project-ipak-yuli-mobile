package com.example.project_ipak_yuli_mobile.core.navigation.routes

import com.example.project_ipak_yuli_mobile.ui.cards.CardsScreen
import androidx.compose.runtime.Composable

@Composable
fun CardsRoute(
    onClickReturn: () -> Unit
) {
    CardsScreen(
        onClickReturn = { onClickReturn() }
    )
}