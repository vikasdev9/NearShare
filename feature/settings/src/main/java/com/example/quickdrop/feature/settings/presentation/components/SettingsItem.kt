package com.example.quickdrop.feature.settings.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.quickdrop.core.ui.components.CircularIcon

@Composable
fun SettingsItem(
    title: String,
    icon: ImageVector,
    iconBg: Color,
    iconTint: Color,
    value: String? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularIcon(
            icon = icon,
            tint = iconTint,
            background = iconBg,
            size = 44.dp,
            iconSize = 20.dp
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary,
            modifier = Modifier.weight(1f)
        )
        
        if (value != null) {
            Text(
                text = value,
                fontSize = 14.sp,
                color = SlateGray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        
        Icon(
            imageVector = Icons.Rounded.ChevronRight,
            contentDescription = null,
            tint = SlateGray,
            modifier = Modifier.size(20.dp)
        )
    }
}
