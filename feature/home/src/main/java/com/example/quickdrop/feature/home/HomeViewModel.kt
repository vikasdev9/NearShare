package com.example.quickdrop.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Videocam
import androidx.lifecycle.ViewModel
import com.example.quickdrop.core.designsystem.theme.GreenTint
import com.example.quickdrop.core.designsystem.theme.LightBlueTint
import com.example.quickdrop.core.designsystem.theme.MintTint
import com.example.quickdrop.core.designsystem.theme.PinkTint
import com.example.quickdrop.core.designsystem.theme.PurpleTint
import com.example.quickdrop.core.designsystem.theme.YellowTint
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
        // Initialize with sample data matching the new design spec
        _uiState.value = HomeUiState(
            storageUsedGb = 64.2,
            storageTotalGb = 128.0,
            categories = persistentListOf(
                CategoryItem(
                    id = "1",
                    name = "Photos",
                    itemCount = "1,284 items",
                    icon = Icons.Rounded.Image,
                    tintColor = MintTint,
                    type = CategoryType.PHOTOS
                ),
                CategoryItem(
                    id = "2",
                    name = "Videos",
                    itemCount = "94 items",
                    icon = Icons.Rounded.Videocam,
                    tintColor = LightBlueTint,
                    type = CategoryType.VIDEOS
                ),
                CategoryItem(
                    id = "3",
                    name = "Music",
                    itemCount = "512 items",
                    icon = Icons.Rounded.MusicNote,
                    tintColor = PurpleTint,
                    type = CategoryType.MUSIC
                ),
                CategoryItem(
                    id = "4",
                    name = "Apps",
                    itemCount = "68 items",
                    icon = Icons.Rounded.Apps,
                    tintColor = GreenTint,
                    type = CategoryType.APPS
                ),
                CategoryItem(
                    id = "5",
                    name = "Docs",
                    itemCount = "230 items",
                    icon = Icons.Rounded.Description,
                    tintColor = YellowTint,
                    type = CategoryType.DOCS
                ),
                CategoryItem(
                    id = "6",
                    name = "Folders",
                    itemCount = "42 items",
                    icon = Icons.Rounded.Folder,
                    tintColor = PinkTint,
                    type = CategoryType.FOLDERS
                )
            )
        )
    }

    fun toggleDarkMode() {
        _uiState.value = _uiState.value.copy(isDarkMode = !_uiState.value.isDarkMode)
    }
}
