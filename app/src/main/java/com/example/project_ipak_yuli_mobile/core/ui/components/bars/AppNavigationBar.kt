package com.example.project_ipak_yuli_mobile.core.ui.components.bars

import com.example.project_ipak_yuli_mobile.core.navigation.navbar.NavBarItems
import com.example.project_ipak_yuli_mobile.core.navigation.MainRoute
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.NavigationBar
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppNavigationBar(
    currentRoute: MainRoute,
    onNavigate: (MainRoute) -> Unit
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = AppColors.AppBackgroundDark
    ) {
        NavBarItems.items.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { onNavigate(navItem.route) },
                icon = {
                    Icon(
                        painter = painterResource(navItem.icon),
                        contentDescription = navItem.title,
                        modifier = Modifier.size(22.dp)
                    )
                },
                label = {
                    Text(
                        text = navItem.title,
                        fontSize = 10.sp,
                        fontWeight =
                            if (currentRoute == navItem.route) FontWeight.Medium
                            else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColors.MintGreen,
                    unselectedIconColor = AppColors.CoolGrayMedium,
                    selectedTextColor = AppColors.MintGreen,
                    unselectedTextColor = AppColors.CoolGrayMedium,
                    indicatorColor = AppColors.Transparent
                )
            )
        }
    }
}