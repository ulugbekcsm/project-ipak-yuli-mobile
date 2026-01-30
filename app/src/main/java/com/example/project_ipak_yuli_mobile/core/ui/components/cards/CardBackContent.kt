package com.example.project_ipak_yuli_mobile.core.ui.components.cards

import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.project_ipak_yuli_mobile.R
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@Composable
fun CardBackContent(
    userCard: UserCard
) {
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
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Web-site: www.ipakyulibank.uz",
                color = AppColors.White,
                fontSize = 9.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "E-mail: info@ipakyulibank.uz",
                color = AppColors.White,
                fontSize = 9.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(20.dp)
                .background(AppColors.White)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_qr_code),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(AppColors.White),
                    modifier = Modifier.size(60.dp),
                )
            }

            Column(
                modifier = Modifier
                    .background(AppColors.Black.copy(alpha = 0.4f))
                    .padding(10.dp)
            ) {
                Text(
                    text = "Refer to issuer for Conditions of Use." +
                            "The card os the property of Ipak Yuli Bank" +
                            "If found should be returned to any branch of" +
                            "Ipak Yuli Bank or our headquarters at",
                    color = AppColors.White,
                    lineHeight = 12.sp,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.width(240.dp)
                )

                Text(
                    text = "2. A. Kodiriy street, Tashkent, Uzbekistan, 100017",
                    color = AppColors.White,
                    lineHeight = 13.sp,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.width(240.dp)
                )

                Text(
                    text = "Customer Service Hotline: (+998 78) 140-69-00, 1296",
                    color = AppColors.White,
                    lineHeight = 13.sp,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.width(240.dp)
                )
            }
        }
    }
}