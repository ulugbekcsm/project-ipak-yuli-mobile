package com.example.project_ipak_yuli_mobile.ui.home

import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.project_ipak_yuli_mobile.core.ui.components.pulltorefresh.PullToRefreshContainer
import com.example.project_ipak_yuli_mobile.ui.home.components.bars.HomeTopBar
import com.example.project_ipak_yuli_mobile.ui.home.components.modals.BalanceCardSelectionSheet
import com.example.project_ipak_yuli_mobile.ui.home.components.sections.HomeBackgroundSection
import com.example.project_ipak_yuli_mobile.ui.home.components.sections.HomeScreenSections

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier,
    onNavigateToCards: () -> Unit
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        HomeBackgroundSection(
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Scaffold(
            containerColor = AppColors.Transparent,
            topBar = {
                HomeTopBar(
                    searchQuery = uiState.searchQuery,
                    onQueryChange = { viewModel.changeSearchQuery(it) }
                )
            }
        ) { innerPadding ->
            PullToRefreshContainer(
                isRefreshing = uiState.isHomeScreenRefreshing,
                onRefresh = { viewModel.refreshHomeScreen() },
                modifier = Modifier
                    .padding(top = innerPadding.calculateTopPadding())
                    .fillMaxSize()
            ) {
                HomeScreenSections(
                    modifier = Modifier,
                    userHomes = uiState.userHomes,
                    bankingServices = uiState.bankingServices,
                    usefulOffers = uiState.usefulOffers,
                    userTransfers = uiState.userTransfers,
                    userCards = uiState.userCards,
                    currentMonth = uiState.currentMonth,

                    isLoading = uiState.isLoading,
                    isBalanceVisible = uiState.isBalanceVisible,
                    onBalanceVisibilityChange = { viewModel.toggleBalanceVisibility() },
                    onBalanceCardSelect = { viewModel.showBalanceCardSheet() },

                    phoneNumberPayment = uiState.phoneNumberPayment,
                    isPhoneNumberPaymentEmpty = uiState.isPhoneNumberPaymentEmpty,
                    onPhoneNumberPaymentChange = { viewModel.changePhoneNumberPayment(it) },
                    onPhoneNumberPaymentClear = { viewModel.clearPhoneNumberPayment() },

                    onExpensesVisibilityChange = { viewModel.toggleExpensesVisibility(it) },
                    onNavigateToCards = { onNavigateToCards() }
                )
            }
        }

        if (uiState.isBalanceCardSheetVisible) {
            BalanceCardSelectionSheet(
                onDismiss = { viewModel.hideBalanceCardSheet() }
            )
        }
    }
}