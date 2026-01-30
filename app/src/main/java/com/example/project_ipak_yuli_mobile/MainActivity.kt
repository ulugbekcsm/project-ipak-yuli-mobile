package com.example.project_ipak_yuli_mobile

import com.example.project_ipak_yuli_mobile.core.ui.theme.ProjectIpakYuliMobileTheme
import com.example.project_ipak_yuli_mobile.core.navigation.AppRoot
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import android.os.Bundle
import android.os.Build

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectIpakYuliMobileTheme {
                AppRoot()
            }
        }
    }
}