package com.example.project_ipak_yuli_mobile.ui.conversion.components.items

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.components.items.CircularItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.domain.model.card.Currency

@Composable
fun TransferSelectCard(
    title: String,
    currency: Currency,
    animateToBottom: Boolean,
    isAnimateActive: Boolean,
    onAnimateDismiss: () -> Unit
) {

    val offsetY = remember { Animatable(0f) }

    LaunchedEffect(isAnimateActive) {
        if (isAnimateActive) {

            val direction = if (animateToBottom) 1 else -1

            offsetY.animateTo(
                targetValue = direction * 50.dp.value,
                animationSpec = tween(durationMillis = 100)
            )

            offsetY.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 100)
            )

            onAnimateDismiss()
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .offset(y = offsetY.value.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(30.dp),
        colors = CardDefaults.cardColors(AppColors.AppBackgroundDark)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                CircularItem(
                    icon = R.drawable.icon_cards_wallet,
                    itemSize = 45.dp,
                    iconSize = 25.dp,
                    itemColor = AppColors.Gunmetal,
                    iconColor = AppColors.CoolGrayNormal
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        color = AppColors.MintGreen,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    ButtonItem(
                        modifier = Modifier.size(16.dp),
                        icon = R.drawable.icon_arrow_down,
                        iconSize = 16.dp,
                        iconColor = AppColors.LightGray,
                        onClick = {}
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Choose a card",
                        color = AppColors.CoolGrayNormal,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = currency.display,
                        color = AppColors.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}