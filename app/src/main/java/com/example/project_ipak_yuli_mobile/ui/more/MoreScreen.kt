package com.example.project_ipak_yuli_mobile.ui.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.project_ipak_yuli_mobile.ui.more.components.bars.MoreTopBar
import com.example.project_ipak_yuli_mobile.ui.more.components.sections.MoreScreenSections

@Composable
fun MoreScreen(
    viewModel: MoreViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        MoreTopBar()

        MoreScreenSections(
            isHideBalanceWithGestureOn = uiState.isHideBalanceWithGestureOn,
            onToggleHideBalanceWithGesture = { viewModel.onToggleHideBalanceWithGesture() },
            isAppVibrationOn = uiState.isAppVibrationOn,
            onToggleAppVibration = { viewModel.onToggleAppVibration() }
        )
    }
}