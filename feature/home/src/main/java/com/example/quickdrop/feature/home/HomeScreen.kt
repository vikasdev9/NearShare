package com.example.quickdrop.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.quickdrop.core.designsystem.theme.BackgroundLight
import com.example.quickdrop.core.designsystem.theme.IndigoDeep
import com.example.quickdrop.core.designsystem.theme.IndigoPrimary
import com.example.quickdrop.core.designsystem.theme.TealDeep
import com.example.quickdrop.core.designsystem.theme.TealPrimary
import com.example.quickdrop.core.designsystem.theme.TextPrimary
import com.example.quickdrop.feature.home.components.BottomNavBar
import com.example.quickdrop.feature.home.components.CategoryCard
import com.example.quickdrop.feature.home.components.HomeTopBar
import com.example.quickdrop.feature.home.components.NavDestination
import com.example.quickdrop.feature.home.components.PrimaryActionCard
import com.example.quickdrop.feature.home.components.StorageCard
import com.example.quickdrop.feature.home.model.CategoryType

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
        onBottomNavClick = { /* Handle bottom nav navigation */ }
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
        bottomBar = {
            BottomNavBar(
                currentDestination = NavDestination.HOME,
                onDestinationClick = onBottomNavClick
            )
        },
        containerColor = BackgroundLight
    ) { paddingValues ->
        // Using LazyColumn as the host for the whole screen content for performance
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item {
                HomeTopBar(
                    onThemeToggle = onThemeToggle,
                    onSettingsClick = onSettingsClick
                )
            }

            item {
                PrimaryActionsSection(
                    onSendClick = onSendClick,
                    onReceiveClick = onReceiveClick
                )
            }

            item {
                BrowseHeader(onSeeAllClick = onSeeAllClick)
            }

            item {
                // Fixed 6-item grid. We pass keys to avoid full recomposition of the list.
                CategoryGrid(
                    categories = uiState.categories,
                    onCategoryClick = onCategoryClick
                )
            }

            item {
                StorageCard(
                    usedGb = uiState.storageUsedGb,
                    totalGb = uiState.storageTotalGb,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                )
            }
        }
    }
}

@Composable
private fun PrimaryActionsSection(
    onSendClick: () -> Unit,
    onReceiveClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PrimaryActionCard(
            title = "Send",
            subtitle = "Share files nearby",
            icon = Icons.Outlined.FileUpload,
            gradientStart = IndigoPrimary,
            gradientEnd = IndigoDeep,
            onClick = onSendClick,
            modifier = Modifier.weight(1f)
        )
        PrimaryActionCard(
            title = "Receive",
            subtitle = "Accept incoming",
            icon = Icons.Outlined.FileDownload,
            gradientStart = TealPrimary,
            gradientEnd = TealDeep,
            onClick = onReceiveClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun BrowseHeader(
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 24.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Browse",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        TextButton(onClick = onSeeAllClick) {
            Text(
                text = "See all",
                fontSize = 15.sp,
                color = IndigoPrimary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun CategoryGrid(
    categories: List<com.example.quickdrop.feature.home.model.CategoryItem>,
    onCategoryClick: (CategoryType) -> Unit
) {
    // We use a custom Box with a simple Column/Row structure or a nested LazyVerticalGrid 
    // depending on requirements. Since LazyColumn items can't contain another vertically 
    // scrollable component without fixed height, and this grid is small (6 items), 
    // we'll implement it as a simple Grid inside an item.
    
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        for (i in 0 until (categories.size + 2) / 3) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
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
