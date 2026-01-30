package com.example.project_ipak_yuli_mobile.ui.conversion.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun TransferAmountInput(
    transferAmount: TextFieldValue,
    isTransferAmountEmpty: Boolean,
    onTransferAmountChange: (TextFieldValue) -> Unit,
    onTransferAmountClear: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isFocused) AppColors.MintGreenLighter else AppColors.Gunmetal,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            if (isTransferAmountEmpty) {
                Text(
                    text = "Enter amount",
                    color = AppColors.LightGray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }

            BasicTextField(
                value = transferAmount,
                onValueChange = { newValue ->
                    onTransferAmountChange(newValue)
                },
                singleLine = true,
                cursorBrush = SolidColor(AppColors.White),
                textStyle = TextStyle(
                    color = AppColors.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                interactionSource = interactionSource,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (!isTransferAmountEmpty) {
                ButtonItem(
                    modifier = Modifier
                        .background(
                            color = AppColors.Gunmetal,
                            shape = RoundedCornerShape(60)
                        )
                        .size(28.dp),
                    icon = R.drawable.icon_x_close,
                    iconSize = 10.dp,
                    iconColor = AppColors.CoolGrayNormal,
                    onClick = { onTransferAmountClear() }
                )
            }

            Text(
                text = "USD",
                color = AppColors.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}