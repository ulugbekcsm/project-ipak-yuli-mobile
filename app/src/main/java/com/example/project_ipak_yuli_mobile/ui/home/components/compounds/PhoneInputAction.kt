package com.example.project_ipak_yuli_mobile.ui.home.components.compounds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
fun PhoneInputAction(
    isPhoneNumberPaymentEmpty: Boolean,
    onPhoneNumberPaymentClear: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (isPhoneNumberPaymentEmpty) {
            Box(
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .fillMaxHeight()
                    .background(
                        color = AppColors.Gunmetal,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "My number",
                    color = AppColors.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        } else {
            ButtonItem(
                modifier = Modifier
                    .background(
                        color = AppColors.Gunmetal,
                        shape = RoundedCornerShape(60)
                    )
                    .size(26.dp),
                icon = R.drawable.icon_x_close,
                iconSize = 8.dp,
                iconColor = AppColors.CoolGrayNormal,
                onClick = { onPhoneNumberPaymentClear() }
            )
        }

        ButtonItem(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(34.dp),
            icon = R.drawable.icon_phone_book,
            iconSize = 28.dp,
            iconColor = AppColors.MintGreenLighter,
            onClick = {}
        )
    }
}