package com.example.project_ipak_yuli_mobile.ui.cards.components.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.cards.components.buttons.ViewModeButton

@Composable
fun CardsTopBar(
    isUserCardsCompactMode: Boolean,
    onToggleCompactMode: () -> Unit,
    onShowCardActionSheet: () -> Unit,
    onClickReturn: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        ButtonItem(
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.CenterStart),
            icon = R.drawable.icon_arrow_left,
            iconSize = 18.dp,
            iconColor = AppColors.White,
            onClick = { onClickReturn() }
        )

        Spacer(modifier = Modifier.width(35.dp))

        Text(
            text = "Cards and wallet",
            color = AppColors.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ViewModeButton(
                isUserCardsCompactMode = isUserCardsCompactMode,
                onClick = { onToggleCompactMode() }
            )

            ButtonItem(
                modifier = Modifier.size(24.dp),
                icon = R.drawable.icon_plus,
                iconSize = 24.dp,
                onClick = { onShowCardActionSheet() }
            )
        }
    }
}