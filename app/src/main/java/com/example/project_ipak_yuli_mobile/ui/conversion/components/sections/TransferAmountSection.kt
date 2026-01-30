package com.example.project_ipak_yuli_mobile.ui.conversion.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TransferAmountSection(
    transferAmount: TextFieldValue,
    isTransferAmountEmpty: Boolean,
    onTransferAmountChange: (TextFieldValue) -> Unit,
    onTransferAmountClear: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Rate: 1 USD = 12 045 UZS",
            color = Color.LightGray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 20.dp)
        )

        TransferAmountInput(
            transferAmount = transferAmount,
            isTransferAmountEmpty = isTransferAmountEmpty,
            onTransferAmountChange = { onTransferAmountChange(it) },
            onTransferAmountClear = { onTransferAmountClear() }
        )
    }
}