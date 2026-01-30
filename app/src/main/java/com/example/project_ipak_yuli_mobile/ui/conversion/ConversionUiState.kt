package com.example.project_ipak_yuli_mobile.ui.conversion

import com.example.project_ipak_yuli_mobile.domain.model.transferswap.TransferRole
import androidx.compose.ui.text.input.TextFieldValue

data class ConversionUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val transferAmount: TextFieldValue = TextFieldValue(""),
    val isTransferAmountEmpty: Boolean = true,

    val isTransferFromUZS: Boolean = true,
    val transferRolePair: Pair<TransferRole, TransferRole> = Pair(
        first = TransferRole.FROM_UZS_TO_USD,
        second = TransferRole.FROM_USD_TO_UZS
    ),

    val isAnimateToBottom: Boolean = false,
    val isAnimateToTop: Boolean = false
)