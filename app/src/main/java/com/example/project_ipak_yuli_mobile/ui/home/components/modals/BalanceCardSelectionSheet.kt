package com.example.project_ipak_yuli_mobile.ui.home.components.modals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalanceCardSelectionSheet(
    onDismiss: () -> Unit
) {

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        shape = RoundedCornerShape(0.dp),
        containerColor = AppColors.DarkBlueGrayNormal,
        sheetState = sheetState,
        onDismissRequest = {
            scope.launch {
                sheetState.hide()
                onDismiss()
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Select the balance you want to see on the main page",
                    color = AppColors.CoolGrayNormal,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )

                ButtonItem(
                    modifier = Modifier.size(22.dp),
                    icon = R.drawable.icon_x_close,
                    iconSize = 20.dp,
                    iconColor = AppColors.White,
                    onClick = {
                        scope.launch {
                            sheetState.hide()
                            onDismiss()
                        }
                    }
                )
            }
        }
    }
}