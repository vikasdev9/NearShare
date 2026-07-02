package com.example.quickdrop.feature.home.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

// @Immutable prevents recomposition when reference is stable
@Immutable
data class CategoryItem(
    val id: String,
    val name: String,
    val itemCount: String,
    val icon: ImageVector,
    val tintColor: Color,
    val type: CategoryType
)

enum class CategoryType {
    PHOTOS, VIDEOS, MUSIC, APPS, DOCS, FOLDERS
}
