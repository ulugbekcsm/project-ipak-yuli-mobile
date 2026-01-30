package com.example.project_ipak_yuli_mobile.ui.conversion.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun ConfirmTransferButton(
    isTransferAmountEmpty: Boolean,
    onClick: () -> Unit
) {

    val backgroundColor = if (isTransferAmountEmpty) AppColors.Gunmetal else AppColors.MintGreenLighter
    val textColor = if (isTransferAmountEmpty) AppColors.LightGray else AppColors.White

    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = "Transfer",
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}