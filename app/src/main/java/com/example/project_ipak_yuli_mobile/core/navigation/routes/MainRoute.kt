package com.example.project_ipak_yuli_mobile.core.navigation.routes

import com.example.project_ipak_yuli_mobile.ui.home.HomeScreen
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.project_ipak_yuli_mobile.core.navigation.MainRoute
import com.example.project_ipak_yuli_mobile.core.ui.components.bars.AppNavigationBar
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.conversion.ConversionScreen
import com.example.project_ipak_yuli_mobile.ui.more.MoreScreen
import com.example.project_ipak_yuli_mobile.ui.payments.PaymentsScreen
import com.example.project_ipak_yuli_mobile.ui.services.ServicesScreen

@Composable
fun MainRoute(
    onNavigateToCards: () -> Unit,
    onExitApp: () -> Unit
) {

    val currentRoute: MutableState<MainRoute> = remember {
        mutableStateOf(MainRoute.Home)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppNavigationBar(
                currentRoute = currentRoute.value,
                onNavigate = { currentRoute.value = it }
            )
        }
    ) { paddingValues ->

        when(currentRoute.value) {

            MainRoute.Home -> {
                HomeScreen(
                    modifier = Modifier
                        .background(AppColors.AppBackgroundDark)
                        .padding(bottom = paddingValues.calculateBottomPadding()),
                    onNavigateToCards = onNavigateToCards
                )
            }

            MainRoute.Services -> {
                ServicesScreen(
                    modifier = Modifier
                        .background(AppColors.AppBackgroundDark)
                        .padding(paddingValues)
                )
            }

            MainRoute.Payments -> {
                PaymentsScreen(
                    modifier = Modifier
                        .background(AppColors.AppBackgroundDark)
                        .padding(paddingValues)
                )
            }

            MainRoute.Conversion -> {
                ConversionScreen(
                    modifier = Modifier
                        .background(AppColors.AppBackgroundDark)
                        .padding(paddingValues)
                )
            }

            MainRoute.More -> {
                MoreScreen(
                    modifier = Modifier
                        .background(AppColors.AppBackgroundDark)
                        .padding(paddingValues)
                )
            }
        }
    }

    BackHandler {
        onExitApp()
    }
}