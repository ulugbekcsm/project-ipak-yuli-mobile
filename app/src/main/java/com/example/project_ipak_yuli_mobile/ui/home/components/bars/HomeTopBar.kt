package com.example.project_ipak_yuli_mobile.ui.home.components.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.core.ui.components.buttons.ButtonItem

@Composable
fun HomeTopBar(
    searchQuery: String,
    onQueryChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .statusBarsPadding()
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonItem(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(32.dp),
                icon = R.drawable.icon_account,
                iconSize = 32.dp,
                iconColor = AppColors.White,
                onClick = {}
            )

            Row(
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(AppColors.White.copy(alpha = 0.25f))
                    .padding(start = 18.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (searchQuery.isEmpty()) {
                        Text(
                            text = "Search",
                            color = AppColors.LightGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }

                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { newValue ->
                            onQueryChange(newValue)
                        },
                        singleLine = true,
                        cursorBrush = SolidColor(AppColors.White),
                        textStyle = TextStyle(
                            color = AppColors.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                ButtonItem(
                    modifier = Modifier.size(40.dp),
                    icon = R.drawable.icon_search,
                    iconSize = 16.dp,
                    iconColor = AppColors.White,
                    onClick = {}
                )
            }

            ButtonItem(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(24.dp),
                icon = R.drawable.icon_notification,
                iconSize = 24.dp,
                iconColor = AppColors.White,
                onClick = {}
            )
        }
    }
}