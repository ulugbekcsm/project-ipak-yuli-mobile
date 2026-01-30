package com.example.project_ipak_yuli_mobile.core.ui.components.cards

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.combinedClickable
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.layout.Box
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun FlippableCard(
    modifier: Modifier = Modifier,
    isFlipped: Boolean,
    canFlip: Boolean,
    onLongPress: () -> Unit,
    frontContent: @Composable () -> Unit,
    backContent: @Composable () -> Unit
) {

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 20 * density
            }
            .combinedClickable(
                enabled = canFlip,
                onClick = {},
                onLongClick = { onLongPress() }
            )
    ) {
        if (rotation <= 90f) {
            frontContent()
        } else {
            Box(
                modifier = Modifier.graphicsLayer { rotationY = 180f }
            ) {
                backContent()
            }
        }
    }
}