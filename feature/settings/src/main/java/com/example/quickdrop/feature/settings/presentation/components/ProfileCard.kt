package com.example.quickdrop.feature.settings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.ShareItBlueEnd
import com.example.quickdrop.core.designsystem.theme.ShareItBlueStart
import com.example.quickdrop.core.ui.components.AnimatedProgressBar
import com.example.quickdrop.core.ui.components.GradientCard

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    GradientCard(
        gradient = Brush.linearGradient(listOf(ShareItBlueStart, ShareItBlueEnd)),
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        // Decorative Circle
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = (-50).dp)
                .size(200.dp)
                .background(Color.White.copy(alpha = 0.08f), CircleShape)
                .align(Alignment.TopEnd)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Avatar
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.White.copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "R",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Riya's Pixel",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.6f),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Text(
                        text = "Pixel 8 Pro • Android 14",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Storage",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
                Text(
                    text = "64.2 / 128 GB",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            AnimatedProgressBar(
                progress = 0.5f,
                gradient = Brush.horizontalGradient(listOf(Color.White, Color.White.copy(alpha = 0.6f))),
                trackColor = Color.White.copy(alpha = 0.2f)
            )
        }
    }
}
