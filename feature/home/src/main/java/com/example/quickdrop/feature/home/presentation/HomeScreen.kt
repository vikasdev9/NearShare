package com.example.quickdrop.feature.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeRoute(
    onTransferClick: (String) -> Unit
) {
    HomeScreen(onTransferClick = onTransferClick)
}

@Composable
internal fun HomeScreen(
    onTransferClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(title = { Text("QuickDrop") })
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
            Button(
                onClick = { onTransferClick("192.168.1.100") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Send File (Demo)")
            }
        }
    }
}
