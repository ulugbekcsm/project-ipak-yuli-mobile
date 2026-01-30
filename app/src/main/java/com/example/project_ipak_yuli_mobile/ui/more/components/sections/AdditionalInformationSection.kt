package com.example.project_ipak_yuli_mobile.ui.more.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.more.components.items.DetailOptionItem

@Composable
fun AdditionalInformationSection() {
    Column(
        modifier = Modifier
            .background(AppColors.BlueBlack)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 22.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Additional Information",
                color = AppColors.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DetailOptionItem(
                icon = R.drawable.icon_bank_map,
                title = "Bank on map",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_public_offer,
                title = "Public offer",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_about_ipak_yuli,
                title = "About Ipak Yuli Modile",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_whats_new,
                title = "What's new?",
                onClick = {}
            )
        }
    }
}