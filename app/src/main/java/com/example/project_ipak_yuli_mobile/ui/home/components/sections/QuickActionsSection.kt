package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.ui.home.components.items.QuickActionItem

@Composable
fun QuickActionsSection(
    onNavigateToCards: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(34.dp)
        ) {
            QuickActionItem(
                icon = R.drawable.icon_cards_wallet,
                iconSize = 24.dp,
                buttonSize = 64.dp,
                title = "Cards and wallet",
                onClick = { onNavigateToCards() }
            )

            QuickActionItem(
                icon = R.drawable.icon_loans,
                iconSize = 24.dp,
                buttonSize = 64.dp,
                title = "Loans",
                onClick = {}
            )

            QuickActionItem(
                icon = R.drawable.icon_deposits,
                iconSize = 26.dp,
                buttonSize = 64.dp,
                title = "Deposits",
                onClick = {}
            )
        }
    }
}