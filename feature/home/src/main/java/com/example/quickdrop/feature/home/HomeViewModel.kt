package com.example.quickdrop.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.quickdrop.feature.home.model.CategoryItem
import com.example.quickdrop.feature.home.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        // Initialize with sample data matching the design spec
        _uiState.value = HomeUiState(
            storageUsedGb = 64.2,
            storageTotalGb = 128.0,
            categories = persistentListOf(
                CategoryItem(
                    id = "1",
                    name = "Photos",
                    itemCount = "1,284 items",
                    icon = Icons.Outlined.Image,
                    tintColor = Color(0xFF10B981), // Mint/Green
                    type = CategoryType.PHOTOS
                ),
                CategoryItem(
                    id = "2",
                    name = "Videos",
                    itemCount = "94 items",
                    icon = Icons.Outlined.Videocam,
                    tintColor = Color(0xFF3B82F6), // Blue
                    type = CategoryType.VIDEOS
                ),
                CategoryItem(
                    id = "3",
                    name = "Music",
                    itemCount = "512 items",
                    icon = Icons.Outlined.MusicNote,
                    tintColor = Color(0xFF8B5CF6), // Purple
                    type = CategoryType.MUSIC
                ),
                CategoryItem(
                    id = "4",
                    name = "Apps",
                    itemCount = "68 items",
                    icon = Icons.Outlined.Apps,
                    tintColor = Color(0xFF22C55E), // Light Green
                    type = CategoryType.APPS
                ),
                CategoryItem(
                    id = "5",
                    name = "Docs",
                    itemCount = "230 items",
                    icon = Icons.Outlined.Description,
                    tintColor = Color(0xFFF59E0B), // Amber/Orange
                    type = CategoryType.DOCS
                ),
                CategoryItem(
                    id = "6",
                    name = "Folders",
                    itemCount = "42 items",
                    icon = Icons.Outlined.Folder,
                    tintColor = Color(0xFFEF4444), // Coral/Red
                    type = CategoryType.FOLDERS
                )
            )
        )
    }

    fun toggleDarkMode() {
        _uiState.value = _uiState.value.copy(isDarkMode = !_uiState.value.isDarkMode)
    }
}
