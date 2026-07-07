package com.example.quickdrop.feature.discovery.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.SignalGreen
import com.example.quickdrop.core.designsystem.theme.SlateGray
import com.example.quickdrop.core.designsystem.theme.TextPrimary
import com.example.quickdrop.core.ui.components.CircularIcon
import com.example.quickdrop.core.ui.components.PrimaryCard
import com.example.quickdrop.feature.discovery.domain.model.Device

@Composable
fun DeviceCard(
    device: Device,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PrimaryCard(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularIcon(
                icon = device.icon,
                tint = MaterialTheme.colorScheme.primary,
                background = device.iconBg,
                size = 52.dp,
                iconSize = 24.dp
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = device.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = device.distance,
                    fontSize = 14.sp,
                    color = SlateGray
                )
            }
            
            SignalIndicator(strength = device.signalStrength)
        }
    }
}

@Composable
private fun SignalIndicator(strength: Int) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        repeat(4) { index ->
            val isActive = index < strength
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height((8 + index * 4).dp)
                    .background(
                        if (isActive) SignalGreen else Color(0xFFE2E8F0),
                        RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}
