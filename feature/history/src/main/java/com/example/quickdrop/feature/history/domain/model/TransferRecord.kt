package com.example.quickdrop.feature.history.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class TransferRecord(
    val id: String,
    val fileName: String,
    val deviceName: String,
    val fileSize: String,
    val time: String,
    val icon: ImageVector,
    val iconTint: Color,
    val iconBg: Color,
    val isSent: Boolean
)
