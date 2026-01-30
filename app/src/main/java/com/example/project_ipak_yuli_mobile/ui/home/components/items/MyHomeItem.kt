package com.example.project_ipak_yuli_mobile.ui.home.components.items

import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun MyHomeItem(
    userHome: UserHome,
    currentMonth: String,
    onExpensesVisibilityChange: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(120.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(AppColors.AppBackgroundDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_home),
                        contentDescription = null,
                        tint = AppColors.MintGreen,
                        modifier = Modifier.size(26.dp)
                    )

                    Text(
                        text = userHome.name,
                        color = AppColors.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Icon(
                    painter = painterResource(R.drawable.icon_arrow_right),
                    contentDescription = null,
                    tint = AppColors.White,
                    modifier = Modifier.size(22.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "Expenses for $currentMonth:",
                        color = AppColors.CoolGrayNormal,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )

                    if (userHome.isExpensesVisible) {
                        Text(
                            text = userHome.expenses,
                            color = AppColors.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    } else {
                        Text(
                            text = "Show expenses",
                            color = AppColors.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                ButtonItem(
                    modifier = Modifier.size(22.dp),
                    icon = if (userHome.isExpensesVisible) R.drawable.icon_eye_hide else R.drawable.icon_eye_show,
                    iconSize = 22.dp,
                    iconColor = AppColors.MintGreen,
                    onClick = { onExpensesVisibilityChange() }
                )
            }
        }
    }
}