package com.example.project_ipak_yuli_mobile.ui.more.components.items

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun ToggleActionItem(
    icon: Int,
    title: String,
    description: String,
    isChecked: Boolean,
    onToggleChanged: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleChanged() }
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(AppColors.AppBackgroundDark)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = AppColors.MintGreen,
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = title,
                        color = AppColors.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Switch(
                    checked = isChecked,
                    onCheckedChange = { onToggleChanged() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AppColors.White,
                        uncheckedThumbColor = AppColors.White,
                        checkedTrackColor = AppColors.MintGreenLighter,
                        uncheckedTrackColor = AppColors.LightGray
                    ),
                    thumbContent = {
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .background(
                                    color = AppColors.White,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                )
            }

            if (isChecked) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 58.dp)
                        .padding(bottom = 6.dp),
                    text = description,
                    color = AppColors.LightGray,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2
                )
            }
        }
    }
}