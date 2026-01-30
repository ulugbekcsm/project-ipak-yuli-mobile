package com.example.project_ipak_yuli_mobile.core.ui.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun ServiceItem(
    icon: String,
    iconSize: Dp = 30.dp,
    name: String,
    nameColor: Color = AppColors.White,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Card(
        modifier = Modifier
            .width(124.dp)
            .height(120.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(AppColors.AppBackgroundDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = icon,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(iconSize)
            )

            Text(
                text = name,
                color = nameColor,
                fontSize = fontSize,
                fontWeight = fontWeight,
                lineHeight = 18.sp,
                maxLines = 3,
                textAlign = TextAlign.Center
            )
        }
    }
}