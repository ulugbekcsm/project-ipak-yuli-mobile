package com.example.project_ipak_yuli_mobile.core.ui.components.cards

import com.example.project_ipak_yuli_mobile.domain.model.card.CardPattern
import com.example.project_ipak_yuli_mobile.domain.model.card.CardVendor
import com.example.project_ipak_yuli_mobile.core.utils.fixExpireDataChange
import com.example.project_ipak_yuli_mobile.core.utils.fixBalanceSpaced
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.core.utils.fixPanSpaced
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.project_ipak_yuli_mobile.core.ui.mapper.iconRes
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun CardFrontContent(
    userCard: UserCard
) {

    val size = if (userCard.pattern == CardPattern.VISASUM.value) 36 else 46

    AsyncImage(
        model = userCard.cover.cover,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(14.dp))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Black.copy(alpha = 0.2f))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            AsyncImage(
                model = userCard.cover.logoImage,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 12.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = fixBalanceSpaced(userCard.balance),
                color = AppColors.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = AppColors.Black.copy(alpha = 0.7f),
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                )
            )

            Text(
                text = userCard.currency,
                color = AppColors.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(
                    start = 6.dp,
                    bottom = 2.dp
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 14.dp, top = 10.dp)
        ) {
            Text(
                text = userCard.title,
                color = AppColors.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(AppColors.Black.copy(alpha = 0.5f))
                    .padding(12.dp)
            ) {
                Text(
                    text = fixPanSpaced(userCard.pan),
                    color = AppColors.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Text(
                text = fixExpireDataChange(userCard.expire),
                color = AppColors.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 34.dp)
            )

            Box(
                modifier = Modifier.size(70.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                when(userCard.vendor) {
                    CardVendor.HUMO.value,
                    CardVendor.UZCARD.value,
                    CardVendor.MC.value,
                    CardVendor.CUP.value -> {
                        AsyncImage(
                            model = userCard.cardPattern.iconRes(),
                            contentDescription = null,
                            modifier = Modifier.width(56.dp)
                        )
                    }

                    CardVendor.VISA.value -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(size.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(AppColors.Black.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = userCard.cardPattern.iconRes(),
                                contentDescription = null,
                                modifier = Modifier.width(50.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}