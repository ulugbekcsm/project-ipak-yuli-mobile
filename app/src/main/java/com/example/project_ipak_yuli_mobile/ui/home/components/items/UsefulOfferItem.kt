package com.example.project_ipak_yuli_mobile.ui.home.components.items

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun UsefulOfferItem(
    modifier: Modifier,
    offer: UsefulOffer
) {
    AsyncImage(
        model = offer.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(66.dp)
            .padding(end = 12.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}