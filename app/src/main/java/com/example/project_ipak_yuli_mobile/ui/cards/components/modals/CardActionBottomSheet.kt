package com.example.project_ipak_yuli_mobile.ui.cards.components.modals

import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.ui.cards.components.buttons.CardOptionButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardActionBottomSheet(
    onDismiss: () -> Unit
) {

    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() },
        containerColor = AppColors.DarkBlueGrayNormal
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            CardOptionButton(R.drawable.icon_add_card, "Add card")
            CardOptionButton(R.drawable.icon_order_card, "Order a card")
            CardOptionButton(R.drawable.icon_open_virtual_card, "Open virtual card")
        }
    }
}