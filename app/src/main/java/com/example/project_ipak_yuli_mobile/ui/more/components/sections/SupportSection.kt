package com.example.project_ipak_yuli_mobile.ui.more.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.ui.more.components.items.ActionOptionItem

@Composable
fun SupportSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ActionOptionItem(
            icon = R.drawable.icon_online_chat,
            title = "Online chat",
            fontWeight = FontWeight.Medium,
            onClick = {}
        )

        ActionOptionItem(
            icon = R.drawable.icon_call_back,
            title = "Call back",
            fontWeight = FontWeight.Medium,
            onClick = {}
        )

        ActionOptionItem(
            icon = R.drawable.icon_my_inquires,
            title = "My inquires",
            fontWeight = FontWeight.Medium,
            onClick = {}
        )
    }
}