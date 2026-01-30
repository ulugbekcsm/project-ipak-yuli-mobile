package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.ServiceItemShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.items.SectionHeader
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.core.ui.components.items.ServiceItem

@Composable
fun BankingServicesSection(
    bankingServices: List<BankingService>,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader(
            title = "Banking services",
            actionTitle = "Set up",
            onClick = {}
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (isLoading) {
                items(3) {
                    ServiceItemShimmer()
                }
            } else {
                items(bankingServices) { service ->
                    ServiceItem(
                        icon = service.icon.link,
                        name = service.name,
                        iconSize = 32.dp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}