package com.example.project_ipak_yuli_mobile.ui.services.components.sections

import com.example.project_ipak_yuli_mobile.core.ui.components.items.ServiceItem
import com.example.project_ipak_yuli_mobile.domain.model.service.Service
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.ServiceItemShimmer

@Composable
fun ServicesSection(
    services: List<Service>,
    isLoading: Boolean
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (isLoading) {
            items(12) {
                ServiceItemShimmer()
            }
        } else {
            items(services) { service ->
                ServiceItem(
                    icon = service.icon.links.dark,
                    name = service.title,
                    iconSize = 34.dp
                )
            }
        }
    }
}