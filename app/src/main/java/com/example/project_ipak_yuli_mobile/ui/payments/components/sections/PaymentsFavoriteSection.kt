package com.example.project_ipak_yuli_mobile.ui.payments.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun PaymentsFavoriteSection(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Favorites",
            color = AppColors.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        ButtonItem(
            modifier = Modifier.size(22.dp),
            icon = R.drawable.icon_arrow_right,
            iconSize = 22.dp,
            iconColor = AppColors.LightGray,
            onClick = { onClick() }
        )
    }
}