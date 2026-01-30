package com.example.project_ipak_yuli_mobile.ui.services

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.project_ipak_yuli_mobile.core.ui.components.bars.SearchTopBar
import com.example.project_ipak_yuli_mobile.ui.services.components.sections.ServicesSection

@Composable
fun ServicesScreen(
    viewModel: ServicesViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchTopBar(
            title = "Services",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        ServicesSection(
            services = uiState.services,
            isLoading = uiState.isLoading
        )
    }
}