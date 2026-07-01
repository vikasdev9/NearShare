package com.example.quickdrop.ui.discovery

import androidx.compose.runtime.*
import com.example.quickdrop.ui.discovery.DiscoveryViewModel
import org.koin.compose.koinInject

@Composable
fun DiscoveryScreen(
    viewModel: DiscoveryViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Manually managing the ViewModel lifecycle tied to this composable
    DisposableEffect(viewModel) {
        viewModel.startDiscovery()
        onDispose {
            viewModel.onCleared()
        }
    }

    // UI Implementation using Compose Desktop
    // ...
}
