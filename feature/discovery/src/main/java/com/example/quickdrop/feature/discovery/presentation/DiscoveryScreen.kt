package com.example.quickdrop.feature.discovery.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.*
import com.example.quickdrop.feature.discovery.domain.model.Device
import com.example.quickdrop.feature.discovery.presentation.components.*

@Composable
fun DiscoveryRoute(
    onBackClick: () -> Unit
) {
    DiscoveryScreen(onBackClick = onBackClick)
}

@Composable
fun DiscoveryScreen(
    onBackClick: () -> Unit
) {
    val dummyDevices = listOf(
        Device("1", "Aarav's iPhone 15", "2m away", Icons.Rounded.Smartphone, InfoBlue, 3),
        Device("2", "MacBook Pro", "5m away", Icons.Rounded.Laptop, PhotosTint, 4),
        Device("3", "Priya's Galaxy Tab", "8m away", Icons.Rounded.TabletAndroid, VideosTint, 2)
    )

    Scaffold(
        containerColor = BackgroundLight,
        topBar = {
            DiscoveryTopBar(onBackClick = onBackClick)
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Find a device",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "Make sure both devices have ShareIt open",
                    fontSize = 16.sp,
                    color = SlateGray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                
                Spacer(modifier = Modifier.height(48.dp))
                
                RadarView()
                
                Spacer(modifier = Modifier.height(56.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Nearby devices",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "3 found",
                        fontSize = 14.sp,
                        color = SlateGray
                    )
                }
                
                Spacer(modifier = Modifier.height(18.dp))
            }
            
            items(dummyDevices) { device ->
                DeviceCard(
                    device = device,
                    onClick = { /* Connect */ },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
private fun DiscoveryTopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier.size(48.dp)
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = TextPrimary
                )
            }
        }
        
        SearchingChip()
        
        Spacer(modifier = Modifier.size(48.dp)) // To keep chip centered
    }
}
