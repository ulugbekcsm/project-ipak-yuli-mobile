package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.math.BigDecimal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.utils.fixBalanceSpaced
import com.example.project_ipak_yuli_mobile.domain.model.card.Currency
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun HomeBalanceSection(
    isBalanceVisible: Boolean,
    onBalanceVisibilityChange: () -> Unit,
    onBalanceCardSelect: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Total balance",
            color = AppColors.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ButtonItem(
                modifier = Modifier.size(24.dp),
                icon = if (isBalanceVisible) R.drawable.icon_eye_hide else R.drawable.icon_eye_show,
                iconSize = 24.dp,
                iconColor = AppColors.White,
                onClick = { onBalanceVisibilityChange() }
            )

            if (isBalanceVisible) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = fixBalanceSpaced(BigDecimal(0)),
                        color = AppColors.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = Currency.UZS.display,
                        color = AppColors.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            } else {
                Text(
                    text = "Show balance",
                    color = AppColors.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            ButtonItem(
                modifier = Modifier.size(24.dp),
                icon = R.drawable.icon_filter,
                iconSize = 24.dp,
                iconColor = AppColors.White,
                onClick = { onBalanceCardSelect() }
            )
        }
    }
}