package com.example.project_ipak_yuli_mobile.core.ui.components.cards

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.core.utils.fixBalanceSpaced
import com.example.project_ipak_yuli_mobile.core.utils.fixPanSpacedLast
import com.example.project_ipak_yuli_mobile.core.utils.getVendorDisplay
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.cards.components.overlays.CardStateOverlayCompact

@Composable
fun CardItemCompact(
    modifier: Modifier = Modifier,
    canFlip: Boolean,
    userCard: UserCard,
    onNavigateToCards: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .clickable{ onNavigateToCards() },
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(AppColors.AppBackgroundDark)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart
                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .clip(RoundedCornerShape(50))
                            .background(AppColors.Gunmetal)
                    )

                    AsyncImage(
                        model = userCard.cover.cover,
                        contentDescription = null,
                        modifier = Modifier.size(55.dp),
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = userCard.title,
                            color = AppColors.LightGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            text = fixPanSpacedLast(userCard.pan),
                            color = AppColors.LightGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${fixBalanceSpaced(userCard.balance)} ${userCard.currency}",
                            color = AppColors.LightGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Text(
                            text = getVendorDisplay(userCard.vendor),
                            color = AppColors.LightGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            if (!canFlip) {
                CardStateOverlayCompact()
            }
        }
    }
}