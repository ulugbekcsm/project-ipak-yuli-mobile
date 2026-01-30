package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun CustomizeWidgetsSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ButtonItem(
                modifier = Modifier.size(18.dp),
                icon = R.drawable.icon_setting,
                iconColor = AppColors.MintGreen,
                iconSize = 19.dp,
                onClick = {}
            )

            Text(
                text = "Customize widgets",
                color = AppColors.MintGreen,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}