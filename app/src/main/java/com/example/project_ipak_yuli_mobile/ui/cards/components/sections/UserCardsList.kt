package com.example.project_ipak_yuli_mobile.ui.cards.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemCompact
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemCompactShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemExpanded
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.CardItemExpandedShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.pulltorefresh.PullToRefreshContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCardsList(
    isLoading: Boolean,
    pagerState: PagerState,
    screenTabs: List<CardTab>,
    isUserCardsCompactMode: Boolean,
    isUserCardsRefreshing: Boolean,
    onUserCardsRefresh: () -> Unit,
    onLongPressUserCard: (String) -> Unit
) {

    val sizeHorizontal = if (isUserCardsCompactMode) 6.dp else 12.dp

    PullToRefreshContainer(
        isRefreshing = isUserCardsRefreshing,
        onRefresh = { onUserCardsRefresh() },
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) {pageIndex ->

            val screenTab = screenTabs[pageIndex]

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = sizeHorizontal),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                if (isLoading) {
                    items(5) {
                        if (isUserCardsCompactMode) {
                            CardItemCompactShimmer()
                        } else {
                            CardItemExpandedShimmer()
                        }
                    }
                } else {
                    items(screenTab.cardList) { userCard ->
                        if (isUserCardsCompactMode) {
                            CardItemCompact(
                                canFlip = userCard.canFlip,
                                userCard = userCard,
                            )
                        } else {
                            CardItemExpanded(
                                userCard = userCard,
                                canFlip = userCard.canFlip,
                                isFlipped = userCard.isFlipped,
                                onLongPressUserCards = { onLongPressUserCard(userCard.id) }
                            )
                        }
                    }
                }

                item { Spacer(modifier = Modifier.height(4.dp)) }
            }
        }
    }
}