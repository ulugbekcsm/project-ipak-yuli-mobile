package com.example.project_ipak_yuli_mobile.ui.cards.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun ViewModeButton(
    isUserCardsCompactMode: Boolean,
    onClick: () -> Unit
) {

    val icon = if (isUserCardsCompactMode) R.drawable.icon_menu_bar_double else R.drawable.icon_menu_bar_triple
    val size = if (isUserCardsCompactMode) 26.dp else 20.dp

    Button(
        onClick = { onClick() },
        modifier = Modifier.size(38.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(AppColors.Transparent)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = AppColors.White,
            modifier = Modifier.size(size),
        )
    }
}