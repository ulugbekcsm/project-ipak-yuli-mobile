package com.example.project_ipak_yuli_mobile.ui.conversion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.project_ipak_yuli_mobile.ui.conversion.components.bars.ConversionTopBar
import com.example.project_ipak_yuli_mobile.ui.conversion.components.buttons.ConfirmTransferButton
import com.example.project_ipak_yuli_mobile.ui.conversion.components.sections.SwapTransferSection
import com.example.project_ipak_yuli_mobile.ui.conversion.components.sections.TransferAmountSection

@Composable
fun ConversionScreen(
    viewModel: ConversionViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            ConversionTopBar()

            SwapTransferSection(
                transferRolePair = uiState.transferRolePair,

                isAnimateToBottom = uiState.isAnimateToBottom,
                isAnimateToTop = uiState.isAnimateToTop,

                onAnimateToBottomDismiss = { viewModel.onAnimateToBottomDismissed() },
                onAnimateToTopDismiss = { viewModel.onAnimateToTopDismissed() },

                onSwapTransfer = { viewModel.onSwapTransferActive() }
            )
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TransferAmountSection(
                transferAmount = uiState.transferAmount,
                isTransferAmountEmpty = uiState.isTransferAmountEmpty,
                onTransferAmountChange = { viewModel.onTransferAmountChanged(it) },
                onTransferAmountClear = { viewModel.onTransferAmountCleared() }
            )

            ConfirmTransferButton(
                isTransferAmountEmpty = uiState.isTransferAmountEmpty,
                onClick = {}
            )
        }
    }
}