package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.project_ipak_yuli_mobile.R
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeBackgroundSection(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.background_home_screen_1),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .height(353.dp)
    )
}