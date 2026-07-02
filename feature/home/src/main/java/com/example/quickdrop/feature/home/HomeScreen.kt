package com.example.quickdrop.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FileDownload
import androidx.compose.material.icons.rounded.FileUpload
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.quickdrop.core.designsystem.theme.*
import com.example.quickdrop.feature.home.components.*
import com.example.quickdrop.feature.home.model.CategoryItem
import com.example.quickdrop.feature.home.model.CategoryType
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeRoute(
    onSendClick: () -> Unit,
    onReceiveClick: () -> Unit,
    onCategoryClick: (CategoryType) -> Unit,
    onSeeAllClick: () -> Unit,
    onSettingsClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        onSendClick = onSendClick,
        onReceiveClick = onReceiveClick,
        onCategoryClick = onCategoryClick,
        onSeeAllClick = onSeeAllClick,
        onThemeToggle = viewModel::toggleDarkMode,
        onSettingsClick = onSettingsClick,
        onBottomNavClick = { /* Navigation logic */ }
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onSendClick: () -> Unit,
    onReceiveClick: () -> Unit,
    onCategoryClick: (CategoryType) -> Unit,
    onSeeAllClick: () -> Unit,
    onThemeToggle: () -> Unit,
    onSettingsClick: () -> Unit,
    onBottomNavClick: (NavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = BackgroundLight, // Pure White
        bottomBar = {
            BottomNavBar(
                currentDestination = NavDestination.HOME,
                onDestinationClick = onBottomNavClick
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // Header Section
            item {
                HomeTopBar(
                    onThemeToggle = onThemeToggle,
                    onSettingsClick = onSettingsClick
                )
            }

            // Primary Actions (Send / Receive)
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    PrimaryActionCard(
                        title = "Send",
                        subtitle = "Share files nearby",
                        icon = Icons.Rounded.FileUpload,
                        gradientStart = ShareItBlueStart,
                        gradientEnd = ShareItBlueEnd,
                        onClick = onSendClick,
                        modifier = Modifier.weight(1f)
                    )
                    PrimaryActionCard(
                        title = "Receive",
                        subtitle = "Accept incoming",
                        icon = Icons.Rounded.FileDownload,
                        gradientStart = ShareItTealStart,
                        gradientEnd = ShareItTealEnd,
                        onClick = onReceiveClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Browse Header
            item {
                BrowseHeader(onSeeAllClick = onSeeAllClick)
            }

            // Category Grid (Implemented as Rows inside item for stability)
            item {
                CategoryGridSection(
                    categories = uiState.categories,
                    onCategoryClick = onCategoryClick
                )
            }

            // Storage Section
            item {
                StorageCard(
                    usedGb = uiState.storageUsedGb,
                    totalGb = uiState.storageTotalGb,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 28.dp)
                )
            }
        }
    }
}

@Composable
private fun BrowseHeader(
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 12.dp, top = 28.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Browse",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
        TextButton(onClick = onSeeAllClick) {
            Text(
                text = "See all",
                fontSize = 16.sp,
                color = ShareItBlueStart,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CategoryGridSection(
    categories: List<CategoryItem>,
    onCategoryClick: (CategoryType) -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // Grid implementation with Rows to maintain layout control within LazyColumn
        for (i in 0 until (categories.size + 2) / 3) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0 until 3) {
                    val index = i * 3 + j
                    if (index < categories.size) {
                        val category = categories[index]
                        CategoryCard(
                            category = category,
                            onClick = { onCategoryClick(category.type) },
                            modifier = Modifier.weight(1f)
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PremiumHomeScreenPreview() {
    HomeScreen(
        uiState = HomeUiState(
            storageUsedGb = 64.2,
            storageTotalGb = 128.0,
            categories = persistentListOf(
                CategoryItem("1", "Photos", "1,284 items", Icons.Rounded.Image, MintTint, CategoryType.PHOTOS),
                CategoryItem("2", "Videos", "94 items", Icons.Rounded.Videocam, LightBlueTint, CategoryType.VIDEOS)
            )
        ),
        onSendClick = {},
        onReceiveClick = {},
        onCategoryClick = {},
        onSeeAllClick = {},
        onThemeToggle = {},
        onSettingsClick = {},
        onBottomNavClick = {}
    )
}
