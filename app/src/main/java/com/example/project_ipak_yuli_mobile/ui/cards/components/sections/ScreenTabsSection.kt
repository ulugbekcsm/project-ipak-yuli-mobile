package com.example.project_ipak_yuli_mobile.ui.cards.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import com.example.project_ipak_yuli_mobile.ui.cards.components.tabs.CardTab

@Composable
fun ScreenTabsSection(
    screenTabs: List<CardTab>,
    selectedTab: CardTab,
    onClickCardCategoryTab: (Int) -> Unit
) {
    PrimaryScrollableTabRow(
        selectedTabIndex = selectedTab.index,
        containerColor = AppColors.DarkBlueGrayNormal,
        minTabWidth = 81.dp,
        edgePadding = 0.dp,
        divider = {},
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        indicator = {
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(selectedTab.index)
                    .height(3.dp)
                    .background(AppColors.MintGreen)
            )
        }
    ) {
        screenTabs.forEach { screenTab ->
            Tab(
                selected = screenTab.isSelected,
                onClick = { onClickCardCategoryTab(screenTab.index) },
                selectedContentColor = AppColors.White,
                unselectedContentColor = AppColors.LightGray
            ) {
                Text(
                    text = screenTab.name,
                    color = if (screenTab.isSelected) AppColors.White else AppColors.CoolGrayMedium,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                )
            }
        }
    }
}