package com.example.project_ipak_yuli_mobile.ui.cards.components.buttons

import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.components.items.CircularItem

@Composable
fun CardOptionButton(
    icon: Int,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CircularItem(
            icon = icon,
            itemSize = 45.dp,
            iconSize = 25.dp,
            itemColor = AppColors.Gunmetal,
            iconColor = AppColors.MintGreen
        )

        Text(
            text = text,
            color = AppColors.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}