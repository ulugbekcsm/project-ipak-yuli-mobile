package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemCompact
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemCompactShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.items.SectionHeader
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard

@Composable
fun MyCardsSection(
    userCards: List<UserCard>,
    isLoading: Boolean,
    onClickAllCards: () -> Unit
) {

    val windowSize = LocalWindowInfo.current.containerSize
    val screenWidth = with(LocalDensity.current) { windowSize.width.toDp() }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader(
            title = "My cards",
            actionTitle = "All",
            onClick = { onClickAllCards() }
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (isLoading) {
                item {
                    CardItemCompactShimmer(
                        Modifier.width(screenWidth - 32.dp)
                    )
                }
            } else {
                items(userCards) { userCard ->
                    CardItemCompact(
                        modifier = Modifier.width(screenWidth - 32.dp),
                        userCard = userCard,
                        canFlip = userCard.canFlip,
                        onNavigateToCards = { onClickAllCards() }
                    )
                }
            }
        }
    }
}