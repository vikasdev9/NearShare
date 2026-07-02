package com.example.quickdrop.feature.onboarding

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object OnboardingIcons {
    val Zap = ImageVector.Builder(
        name = "Zap",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(Color.White),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(13f, 2f)
        lineTo(3f, 14f)
        horizontalLineTo(12f)
        lineTo(11f, 22f)
        lineTo(21f, 10f)
        horizontalLineTo(12f)
        lineTo(13f, 2f)
        close()
    }.build()

    val WifiOff = ImageVector.Builder(
        name = "WifiOff",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(Color.White),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(2f, 2f)
        lineTo(22f, 22f)
        moveTo(16.72f, 11.06f)
        curveTo(17.55f, 11.89f, 18.21f, 12.87f, 18.67f, 13.94f)
        moveTo(5f, 12.55f)
        curveTo(5.95f, 11.6f, 7.07f, 10.84f, 8.31f, 10.3f)
        moveTo(12f, 17f)
        lineTo(12.01f, 17f)
        moveTo(10.51f, 5f)
        curveTo(13.62f, 4.41f, 16.91f, 5.11f, 19.53f, 7.11f)
        moveTo(1.42f, 9f)
        curveTo(2.11f, 8.31f, 2.87f, 7.7f, 3.68f, 7.18f)
    }.build()

    val Copy = ImageVector.Builder(
        name = "Copy",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(Color.White),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(16f, 4f)
        horizontalLineTo(4f)
        verticalLineTo(16f)
        moveTo(20f, 8f)
        horizontalLineTo(8f)
        verticalLineTo(20f)
        horizontalLineTo(20f)
        verticalLineTo(8f)
        close()
    }.build()
}
