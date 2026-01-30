package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.ServiceItemShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.items.SectionHeader
import com.example.project_ipak_yuli_mobile.domain.model.favourite.Favourite
import com.example.project_ipak_yuli_mobile.ui.home.components.items.AddFavouriteItem

@Composable
fun FavouritesSection(
    favourites: List<Favourite> = emptyList(),
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader(
            title = "Favourites",
            actionTitle = "All",
            onClick = {}
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                if (favourites.isEmpty()) Arrangement.Start
                else Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            if (isLoading) {
                item {
                    ServiceItemShimmer()
                }
            } else {
                items(favourites) {
                    AddFavouriteItem()
                }

                item {
                    AddFavouriteItem()
                }
            }
        }
    }
}