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
import com.example.project_ipak_yuli_mobile.core.ui.components.cards.MyHomeItemShimmer
import com.example.project_ipak_yuli_mobile.core.ui.components.items.SectionHeader
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.ui.home.components.items.AddHomeItem
import com.example.project_ipak_yuli_mobile.ui.home.components.items.MyHomeItem

@Composable
fun MyHomeSection(
    userHomes: List<UserHome>,
    isLoading: Boolean,
    currentMonth: String,
    onExpensesVisibilityChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
       SectionHeader(
           title = "Home",
           actionTitle = "All",
           onClick = {}
       )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (isLoading) {
                items(2) {
                    MyHomeItemShimmer()
                }
            } else {
                items(userHomes) { userHome ->
                    MyHomeItem(
                        userHome = userHome,
                        currentMonth = currentMonth,
                        onExpensesVisibilityChange = { onExpensesVisibilityChange(userHome.id) }
                    )
                }

                item {
                    AddHomeItem()
                }
            }
        }
    }
}