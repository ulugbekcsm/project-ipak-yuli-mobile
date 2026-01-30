package com.example.project_ipak_yuli_mobile.core.ui.components.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun CircularItem(
    icon: Int,
    itemSize: Dp,
    iconSize: Dp,
    itemColor: Color,
    iconColor: Color
) {
    Box(
        modifier = Modifier
            .size(itemSize)
            .clip(RoundedCornerShape(50))
            .background(itemColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(iconSize)
        )
    }
}