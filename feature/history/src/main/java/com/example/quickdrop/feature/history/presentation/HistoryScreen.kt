package com.example.quickdrop.feature.history.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.*
import com.example.quickdrop.core.ui.components.SectionTitle
import com.example.quickdrop.feature.history.domain.model.TransferRecord
import com.example.quickdrop.feature.history.presentation.components.*

@Composable
fun HistoryRoute() {
    HistoryScreen()
}

@Composable
fun HistoryScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf(TransferType.SENT) }

    val dummyToday = listOf(
        TransferRecord("1", "vacation_photos.zip", "MacBook Pro", "820 MB", "10:24 AM", Icons.Rounded.Image, Color(0xFF10B981), PhotosTint, true),
        TransferRecord("2", "resume_final.pdf", "Riya's Pixel", "1.2 MB", "9:02 AM", Icons.Rounded.Description, Color(0xFFF59E0B), DocsTint, true)
    )

    val dummyYesterday = listOf(
        TransferRecord("3", "concert_clip.mov", "iPhone 15", "324 MB", "8:41 PM", Icons.Rounded.Videocam, Color(0xFF3B82F6), VideosTint, true),
        TransferRecord("4", "playlist_2024.zip", "iPhone 15", "148 MB", "6:12 PM", Icons.Rounded.MusicNote, Color(0xFF8B5CF6), MusicTint, true)
    )

    Scaffold(
        containerColor = BackgroundLight
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(24.dp)
        ) {
            item {
                HistoryHeader()
                Spacer(modifier = Modifier.height(28.dp))
                HistorySearchBar(query = searchQuery, onQueryChange = { searchQuery = it })
                Spacer(modifier = Modifier.height(28.dp))
                HistorySegmentedControl(selectedType = selectedTab, onTypeSelected = { selectedTab = it })
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionTitle(text = "Today")
                Spacer(modifier = Modifier.height(18.dp))
                HistoryCard(records = dummyToday)
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionTitle(text = "Yesterday")
                Spacer(modifier = Modifier.height(18.dp))
                HistoryCard(records = dummyYesterday)
                Spacer(modifier = Modifier.height(100.dp)) // Padding for bottom nav
            }
        }
    }
}

@Composable
private fun HistoryHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "History",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        
        Surface(
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier.size(52.dp)
        ) {
            IconButton(onClick = { /* Filter */ }) {
                Icon(
                    imageVector = Icons.Rounded.Tune,
                    contentDescription = "Filter",
                    tint = TextPrimary
                )
            }
        }
    }
}
