package com.example.project_ipak_yuli_mobile.core.ui.components.bars

import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.font.FontWeight
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTopBar(
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        Text(
            text = title,
            color = AppColors.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )

        ButtonItem(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 12.dp),
            icon = R.drawable.icon_search,
            iconSize = 18.dp,
            iconColor = AppColors.White,
            onClick = { onClick() }
        )
    }
}