package com.example.project_ipak_yuli_mobile.ui.payments

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
import com.example.project_ipak_yuli_mobile.ui.payments.components.sections.PaymentsFavoriteSection
import com.example.project_ipak_yuli_mobile.ui.payments.components.sections.PaymentsSection

@Composable
fun PaymentsScreen(
    viewmodel: PaymentsViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val uiState = viewmodel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchTopBar(
            title = "Payments",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(14.dp))

        PaymentsFavoriteSection(
            onClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        PaymentsSection(
            modifier = Modifier.weight(1f),
            payments = uiState.payments,
            isLoading = uiState.isLoading
        )
    }
}