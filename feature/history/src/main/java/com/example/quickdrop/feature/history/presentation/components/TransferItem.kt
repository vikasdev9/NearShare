package com.example.quickdrop.feature.history.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CallMade
import androidx.compose.material.icons.rounded.CallReceived
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.SlateGray
import com.example.quickdrop.core.designsystem.theme.TextPrimary
import com.example.quickdrop.core.ui.components.CircularIcon
import com.example.quickdrop.feature.history.domain.model.TransferRecord

@Composable
fun TransferItem(
    record: TransferRecord,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularIcon(
            icon = record.icon,
            tint = record.iconTint,
            background = record.iconBg,
            size = 48.dp,
            iconSize = 22.dp
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = record.fileName,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = "${if (record.isSent) "To" else "From"} ${record.deviceName} • ${record.fileSize}",
                fontSize = 14.sp,
                color = SlateGray
            )
        }
        
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = record.time,
                fontSize = 12.sp,
                color = SlateGray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Icon(
                imageVector = if (record.isSent) Icons.Rounded.CallMade else Icons.Rounded.CallReceived,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
