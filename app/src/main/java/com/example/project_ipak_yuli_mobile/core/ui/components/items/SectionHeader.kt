package com.example.project_ipak_yuli_mobile.core.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun SectionHeader(
    title: String,
    actionTitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp, vertical = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = AppColors.CoolGrayNormal,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = actionTitle,
            color = AppColors.MintGreen,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}