package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.home.components.compounds.PhoneInputAction
import com.example.project_ipak_yuli_mobile.ui.home.components.compounds.PhoneNumberPaymentInput

@Composable
fun PhonePaymentSection(
    phoneNumberPayment: TextFieldValue,
    isPhoneNumberPaymentEmpty: Boolean,
    onPhoneNumberPaymentChange: (TextFieldValue) -> Unit,
    onPhoneNumberPaymentClear: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Pay for phone",
            color = AppColors.CoolGrayNormal,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 18.dp)
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    color = if (isFocused) AppColors.MintGreenLighter else AppColors.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(start = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PhoneNumberPaymentInput(
                interactionSource = interactionSource,
                phoneNumberPayment = phoneNumberPayment,
                onPhoneNumberPaymentChange = { onPhoneNumberPaymentChange(it) }
            )

            PhoneInputAction(
                isPhoneNumberPaymentEmpty = isPhoneNumberPaymentEmpty,
                onPhoneNumberPaymentClear = onPhoneNumberPaymentClear
            )
        }
    }
}