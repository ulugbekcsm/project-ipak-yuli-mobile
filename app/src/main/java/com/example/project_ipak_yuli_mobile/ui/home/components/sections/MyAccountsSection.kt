package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MyAccountsSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "My accounts",
            color = AppColors.CoolGrayNormal,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 18.dp)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(
                    color = AppColors.Gunmetal,
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxWidth()
                .height(66.dp),
            contentAlignment = Alignment.Center
        ) {
            ButtonItem(
                modifier = Modifier.size(30.dp),
                icon = R.drawable.icon_plus,
                iconSize = 30.dp,
                onClick = {}
            )
        }
    }
}