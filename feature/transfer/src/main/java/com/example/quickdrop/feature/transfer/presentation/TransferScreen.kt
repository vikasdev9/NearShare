package com.example.quickdrop.feature.transfer.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TransferRoute(
    onBackClick: () -> Unit,
    viewModel: TransferViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TransferScreen(uiState = uiState, onBackClick = onBackClick)
}

@Composable
internal fun TransferScreen(
    uiState: TransferUiState,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(title = { Text("Transfer") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (uiState) {
                is TransferUiState.Idle -> {
                    Text("Waiting to start...")
                }
                is TransferUiState.Transferring -> {
                    Text(text = "Sending: ${uiState.fileName}", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    LinearProgressIndicator(
                        progress = uiState.progress,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = uiState.speed, style = MaterialTheme.typography.bodySmall)
                }
                is TransferUiState.Success -> {
                    Text("Transfer Successful!", color = MaterialTheme.colorScheme.primary)
                    Button(onClick = onBackClick) { Text("Done") }
                }
                is TransferUiState.Error -> {
                    Text("Error: ${uiState.message}", color = MaterialTheme.colorScheme.error)
                    Button(onClick = onBackClick) { Text("Back") }
                }
            }
        }
    }
}
