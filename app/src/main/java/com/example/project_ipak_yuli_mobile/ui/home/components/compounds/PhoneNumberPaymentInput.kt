package com.example.project_ipak_yuli_mobile.ui.home.components.compounds

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun PhoneNumberPaymentInput(
    interactionSource: MutableInteractionSource,
    phoneNumberPayment: TextFieldValue,
    onPhoneNumberPaymentChange: (TextFieldValue) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "+998",
            color = AppColors.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        BasicTextField(
            value = phoneNumberPayment,
            onValueChange = { onPhoneNumberPaymentChange(it) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            cursorBrush = SolidColor(AppColors.White),
            textStyle = TextStyle(
                color = AppColors.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            interactionSource = interactionSource,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}