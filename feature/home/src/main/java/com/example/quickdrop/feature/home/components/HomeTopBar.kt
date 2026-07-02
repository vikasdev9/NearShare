package com.example.quickdrop.feature.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.SlateGray
import com.example.quickdrop.core.designsystem.theme.TextPrimary

@Composable
fun HomeTopBar(
    onThemeToggle: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Welcome back",
                fontSize = 16.sp,
                color = SlateGray,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "ShareIt",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        }

        Row {
            TopBarButton(
                icon = Icons.Rounded.DarkMode,
                onClick = onThemeToggle
            )
            Spacer(modifier = Modifier.width(12.dp))
            TopBarButton(
                icon = Icons.Rounded.Settings,
                onClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun TopBarButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Surface(
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        shadowElevation = 4.dp,
        modifier = Modifier.size(48.dp)
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = TextPrimary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
