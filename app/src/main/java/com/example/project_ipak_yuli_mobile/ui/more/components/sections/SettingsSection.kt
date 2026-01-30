package com.example.project_ipak_yuli_mobile.ui.more.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.more.components.items.DetailOptionItem
import com.example.project_ipak_yuli_mobile.ui.more.components.items.ToggleActionItem

@Composable
fun SettingsSection(
    isHideBalanceWithGestureOn: Boolean,
    onToggleHideBalanceWithGesture: () -> Unit,
    isAppVibrationOn: Boolean,
    onToggleAppVibration: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(AppColors.BlueBlack)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 26.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Settings",
                color = AppColors.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DetailOptionItem(
                icon = R.drawable.icon_language,
                title = "Language",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_change_theme,
                title = "Change theme",
                extra = "Dark",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_change_background,
                title = "Change background",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_security,
                title = "Security settings",
                onClick = {}
            )

            ToggleActionItem(
                icon = R.drawable.icon_phone_rotate,
                title = "Hide balance with gesture",
                isChecked = isHideBalanceWithGestureOn,
                description = "Turn the phone screen down to hide/show the balance",
                onToggleChanged = { onToggleHideBalanceWithGesture() }
            )

            ToggleActionItem(
                icon = R.drawable.icon_phone_vibration,
                title = "Vibration",
                description = "Turns off in-app vibration",
                isChecked = isAppVibrationOn,
                onToggleChanged = { onToggleAppVibration() }
            )

            DetailOptionItem(
                icon = R.drawable.iocn_share,
                title = "Share",
                onClick = {}
            )

            DetailOptionItem(
                icon = R.drawable.icon_trash,
                title = "Clear cache",
                onClick = {}
            )
        }
    }
}