package com.example.project_ipak_yuli_mobile.ui.more.components.sections

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MoreScreenSections(
    isHideBalanceWithGestureOn: Boolean,
    onToggleHideBalanceWithGesture: () -> Unit,
    isAppVibrationOn: Boolean,
    onToggleAppVibration: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SupportSection()
        }
        item {
            AdditionalInformationSection()
        }
        item {
            SettingsSection(
                isHideBalanceWithGestureOn = isHideBalanceWithGestureOn,
                onToggleHideBalanceWithGesture = { onToggleHideBalanceWithGesture() },
                isAppVibrationOn = isAppVibrationOn,
                onToggleAppVibration = { onToggleAppVibration() }
            )
        }
    }
}