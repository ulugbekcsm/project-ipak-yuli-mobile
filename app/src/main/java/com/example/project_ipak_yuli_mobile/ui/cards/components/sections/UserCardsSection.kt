package com.example.project_ipak_yuli_mobile.ui.cards.components.sections

import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCardsSection(
    isLoading: Boolean,
    screenTabs: List<CardTab>,

    isUserCardsCompactMode: Boolean,
    isUserCardsRefreshing: Boolean,
    onUserCardsRefresh: () -> Unit,

    onClickCardCategoryTab: (Int) -> Unit,
    onLongPressUserCard: (String) -> Unit
) {

    val selectedTab = screenTabs.first { it.isSelected }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { screenTabs.size }
    )

    LaunchedEffect(selectedTab) {
        pagerState.animateScrollToPage(selectedTab.index)
    }

    LaunchedEffect(pagerState.currentPage) {
        if (selectedTab.index != pagerState.currentPage) {
            onClickCardCategoryTab(pagerState.currentPage)
        }
    }

    Column(
        Modifier.fillMaxSize()
    ) {
        ScreenTabsSection(
            screenTabs = screenTabs,
            selectedTab = selectedTab,
            onClickCardCategoryTab = { onClickCardCategoryTab(it) }
        )

        UserCardsList(
            isLoading = isLoading,
            pagerState = pagerState,
            screenTabs = screenTabs,
            isUserCardsCompactMode = isUserCardsCompactMode,
            isUserCardsRefreshing = isUserCardsRefreshing,
            onUserCardsRefresh = { onUserCardsRefresh() },
            onLongPressUserCard = { onLongPressUserCard(it) },
        )
    }
}