package com.example.project_ipak_yuli_mobile.ui.conversion.components.buttons

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun SwapTransferButton(
    modifier: Modifier,
    onClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.25f else 1f,
        animationSpec = tween(durationMillis = 120, easing = FastOutSlowInEasing)
    )

    Box(
        modifier = modifier
            .padding(end = 60.dp)
            .scale(scale)
            .border(
                width = 7.dp,
                color = AppColors.DarkBlueGrayMedium,
                shape = RoundedCornerShape(50)
            )
            .padding(2.dp)
            .background(
                color = AppColors.MintGreenLighter,
                shape = RoundedCornerShape(50)
            )
            .size(60.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_swap_up_down),
            contentDescription = null,
            tint = AppColors.White,
            modifier = Modifier
                .size(26.dp)
                .scale(scaleX = 1f, scaleY = -1f)
        )
    }
}