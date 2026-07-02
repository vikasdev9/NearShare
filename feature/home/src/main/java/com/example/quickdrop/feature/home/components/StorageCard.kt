package com.example.quickdrop.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.SlateGray
import com.example.quickdrop.core.designsystem.theme.TextPrimary
import com.example.quickdrop.core.designsystem.theme.ShareItBlueStart
import com.example.quickdrop.core.designsystem.theme.ShareItTealStart

@Composable
fun StorageCard(
    usedGb: Double,
    totalGb: Double,
    modifier: Modifier = Modifier
) {
    val progress by remember(usedGb, totalGb) {
        derivedStateOf {
            if (totalGb > 0) (usedGb / totalGb).toFloat().coerceIn(0f, 1f) else 0f
        }
    }

    Surface(
        shape = RoundedCornerShape(24.dp),
        color = Color.White,
        shadowElevation = 6.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Storage",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "$usedGb GB of $totalGb GB",
                    fontSize = 15.sp,
                    color = SlateGray,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Premium Gradient Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFF1F5F9))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(ShareItBlueStart, ShareItTealStart)
                            )
                        )
                )
            }
        }
    }
}
