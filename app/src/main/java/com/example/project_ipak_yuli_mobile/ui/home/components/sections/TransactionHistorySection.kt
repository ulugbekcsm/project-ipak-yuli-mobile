package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.TransactionItemShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.items.SectionHeader
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import com.example.project_ipak_yuli_mobile.ui.home.components.items.TransactionItem

@Composable
fun TransactionHistorySection(
    userTransfers: List<UserTransfer>,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader(
            title = "Transaction history",
            actionTitle = "All",
            onClick = {}
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (isLoading) {
                TransactionItemShimmer()
                TransactionItemShimmer()
            } else {
                userTransfers.take(3).forEach { transfer ->
                    TransactionItem(
                        transfer = transfer
                    )
                }
            }
        }
    }
}