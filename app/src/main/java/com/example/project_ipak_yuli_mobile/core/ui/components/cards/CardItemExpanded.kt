package com.example.project_ipak_yuli_mobile.core.ui.components.cards

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.ui.cards.components.overlays.CardStateOverlayExpanded

@Composable
fun CardItemExpanded(
    userCard: UserCard,
    canFlip: Boolean,
    isFlipped: Boolean,
    onLongPressUserCards: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        FlippableCard(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(14.dp)),
            frontContent = { CardFrontContent(userCard) },
            backContent = { CardBackContent(userCard) },
            isFlipped = isFlipped,
            canFlip = canFlip,
            onLongPress = { onLongPressUserCards() }
        )

        if (!canFlip) CardStateOverlayExpanded()
    }
}