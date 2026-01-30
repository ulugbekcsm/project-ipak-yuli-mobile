package com.example.project_ipak_yuli_mobile.core.navigation

import com.example.project_ipak_yuli_mobile.core.navigation.routes.CardsRoute
import com.example.project_ipak_yuli_mobile.core.navigation.routes.MainRoute
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.navigation3.runtime.entryProvider
import androidx.activity.compose.LocalActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation3.ui.NavDisplay
import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.compose.ui.Modifier
import android.os.Build

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun AppRoot() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.AppBackgroundDark
    ) {

        val navBackStack = rememberNavBackStack(AppRoute.Main)
        val activity = LocalActivity.current

        Scaffold {
            NavDisplay(
                modifier = Modifier.fillMaxSize(),
                backStack = navBackStack,
                onBack = {
                    if (navBackStack.size > 1) {
                        navBackStack.removeLast()
                    } else {
                        activity?.finish()
                    }
                },
                entryProvider = entryProvider {
                    entry<AppRoute.Main> {
                        MainRoute(
                            onNavigateToCards = { navBackStack.add(AppRoute.Cards) },
                            onExitApp = { activity?.finish() }
                        )
                    }

                    entry<AppRoute.Cards> {
                        CardsRoute(
                            onClickReturn = { navBackStack.removeLastOrNull() }
                        )
                    }
                }
            )
        }
    }
}