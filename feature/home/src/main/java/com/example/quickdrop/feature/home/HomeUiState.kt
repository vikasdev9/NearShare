package com.example.quickdrop.feature.home

import androidx.compose.runtime.Immutable
import com.example.quickdrop.feature.home.model.CategoryItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

// @Immutable ensures that the Compose compiler knows this state object won't change its properties 
// after construction, allowing efficient skipping of recomposition.
@Immutable
data class HomeUiState(
    val storageUsedGb: Double = 0.0,
    val storageTotalGb: Double = 0.0,
    val categories: ImmutableList<CategoryItem> = persistentListOf(),
    val isDarkMode: Boolean = false,
    val isLoading: Boolean = false
)
