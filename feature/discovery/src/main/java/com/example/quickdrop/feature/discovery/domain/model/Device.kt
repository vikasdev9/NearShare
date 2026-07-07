package com.example.quickdrop.feature.discovery.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class Device(
    val id: String,
    val name: String,
    val distance: String,
    val icon: ImageVector,
    val iconBg: Color,
    val signalStrength: Int // 1-4
)
