package com.example.quickdrop.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Indigo600,
    secondary = Teal500,
    background = Gray100,
    surface = androidx.compose.ui.graphics.Color.White,
)

@Composable
fun QuickDropTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        content = content
    )
}
