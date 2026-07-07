package com.example.quickdrop.feature.history.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.SlateGray
import com.example.quickdrop.core.designsystem.theme.TextPrimary

enum class TransferType {
    SENT, RECEIVED
}

@Composable
fun HistorySegmentedControl(
    selectedType: TransferType,
    onTypeSelected: (TransferType) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFF1F5F9), CircleShape)
            .padding(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            TabItem(
                text = "Sent",
                isSelected = selectedType == TransferType.SENT,
                onClick = { onTypeSelected(TransferType.SENT) },
                modifier = Modifier.weight(1f)
            )
            TabItem(
                text = "Received",
                isSelected = selectedType == TransferType.RECEIVED,
                onClick = { onTypeSelected(TransferType.RECEIVED) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        if (isSelected) Color.White else Color.Transparent,
        label = "tab_bg"
    )
    val textColor by animateColorAsState(
        if (isSelected) TextPrimary else SlateGray,
        label = "tab_text"
    )

    Surface(
        modifier = modifier
            .fillMaxHeight()
            .clip(CircleShape)
            .clickable(onClick = onClick),
        color = backgroundColor,
        shape = CircleShape,
        shadowElevation = if (isSelected) 4.dp else 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
            )
        }
    }
}
