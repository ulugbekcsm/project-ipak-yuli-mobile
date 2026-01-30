package com.example.project_ipak_yuli_mobile.ui.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.cards.components.bars.CardsTopBar
import com.example.project_ipak_yuli_mobile.ui.cards.components.modals.CardActionBottomSheet
import com.example.project_ipak_yuli_mobile.ui.cards.components.sections.UserCardsSection

@Composable
fun CardsScreen(
    viewModel: CardsViewModel = hiltViewModel(),
    onClickReturn: () -> Unit
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier
            .background(AppColors.AppBackgroundDark)
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
            .background(AppColors.AppBackgroundDark)
    ) {
        CardsTopBar(
            isUserCardsCompactMode = uiState.isUserCardsCompactMode,
            onToggleCompactMode = { viewModel.toggleCompactMode() },
            onShowCardActionSheet = { viewModel.showCardActionSheet() },
            onClickReturn = { onClickReturn() }
        )

        UserCardsSection(
            isLoading = uiState.isLoading,
            screenTabs = uiState.cardTabs,

            isUserCardsCompactMode = uiState.isUserCardsCompactMode,
            isUserCardsRefreshing = uiState.isUserCardsRefreshing,
            onUserCardsRefresh = { viewModel.refreshCardsScreen() },

            onLongPressUserCard = { viewModel.toggleCardFlip(it) },
            onClickCardCategoryTab = { viewModel.changeCardCategoryTab(it) }
        )
    }

    if (uiState.isCardActionSheetVisible) {
        CardActionBottomSheet(
            onDismiss = { viewModel.hideCardActionSheet() }
        )
    }
}