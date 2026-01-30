package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.UsefulOfferItemShimmer
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.ui.home.components.items.UsefulOfferItem

@Composable
fun UsefulOffersSection(
    usefulOffers: List<UsefulOffer>,
    isLoading: Boolean
) {

    val windowSize = LocalWindowInfo.current.containerSize
    val screenWidth = with(LocalDensity.current) { windowSize.width.toDp() }

    val listState = rememberLazyListState()

    val flingBehavior = rememberSnapFlingBehavior(
        lazyListState = listState
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Useful",
            color = AppColors.CoolGrayNormal,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 18.dp)
        )

        LazyRow(
            state = listState,
            flingBehavior = flingBehavior,
            contentPadding = PaddingValues(start = 22.dp)
        ) {
            if (isLoading) {
                item {
                    UsefulOfferItemShimmer()
                }
            } else {
                items(usefulOffers) { offer ->
                    UsefulOfferItem(
                        modifier = Modifier.width(screenWidth - 20.dp),
                        offer = offer
                    )
                }
            }
        }
    }
}