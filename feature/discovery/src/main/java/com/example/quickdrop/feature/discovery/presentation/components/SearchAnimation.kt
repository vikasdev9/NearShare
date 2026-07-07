package com.example.quickdrop.feature.discovery.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quickdrop.core.designsystem.theme.ShareItBlueEnd
import com.example.quickdrop.core.designsystem.theme.ShareItBlueStart

@Composable
fun RadarView(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "radar")
    
    val ripples = listOf(
        infiniteTransition.animateFloat(
            initialValue = 0.6f, targetValue = 2.4f,
            animationSpec = infiniteRepeatable(tween(2000, easing = LinearEasing), RepeatMode.Restart), label = "r1"
        ),
        infiniteTransition.animateFloat(
            initialValue = 0.6f, targetValue = 2.4f,
            animationSpec = infiniteRepeatable(tween(2000, delayMillis = 600, easing = LinearEasing), RepeatMode.Restart), label = "r2"
        ),
        infiniteTransition.animateFloat(
            initialValue = 0.6f, targetValue = 2.4f,
            animationSpec = infiniteRepeatable(tween(2000, delayMillis = 1200, easing = LinearEasing), RepeatMode.Restart), label = "r3"
        )
    )

    Box(
        modifier = modifier.size(300.dp),
        contentAlignment = Alignment.Center
    ) {
        ripples.forEach { progress ->
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .scale(progress.value)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = (2.4f - progress.value) / 4f),
                        shape = CircleShape
                    )
            )
        }

        // Center Button
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    brush = Brush.linearGradient(listOf(ShareItBlueStart, ShareItBlueEnd)),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Wifi,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
