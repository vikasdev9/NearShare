package com.example.quickdrop.feature.settings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.*
import com.example.quickdrop.core.ui.components.PrimaryCard
import com.example.quickdrop.core.ui.components.SectionTitle
import com.example.quickdrop.feature.settings.presentation.components.ProfileCard
import com.example.quickdrop.feature.settings.presentation.components.SettingsItem

@Composable
fun ProfileRoute() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
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
                Text(
                    text = "Profile",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(28.dp))
                ProfileCard()
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionTitle(text = "Preferences")
                Spacer(modifier = Modifier.height(18.dp))
                PrimaryCard {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                        SettingsItem(
                            title = "Save location",
                            icon = Icons.Rounded.FolderOpen,
                            iconBg = PhotosTint,
                            iconTint = Color(0xFF10B981),
                            value = "Downloads/ShareIt",
                            onClick = { }
                        )
                        HorizontalDivider(color = BorderLight)
                        SettingsItem(
                            title = "Appearance",
                            icon = Icons.Rounded.Nightlight,
                            iconBg = VideosTint,
                            iconTint = Color(0xFF3B82F6),
                            value = "System",
                            onClick = { }
                        )
                        HorizontalDivider(color = BorderLight)
                        SettingsItem(
                            title = "Language",
                            icon = Icons.Rounded.Language,
                            iconBg = MusicTint,
                            iconTint = Color(0xFF8B5CF6),
                            value = "English",
                            onClick = { }
                        )
                        HorizontalDivider(color = BorderLight)
                        SettingsItem(
                            title = "Notifications",
                            icon = Icons.Rounded.Notifications,
                            iconBg = DocsTint,
                            iconTint = Color(0xFFF59E0B),
                            value = "On",
                            onClick = { }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionTitle(text = "About")
                Spacer(modifier = Modifier.height(18.dp))
                PrimaryCard {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                        SettingsItem(
                            title = "Privacy & security",
                            icon = Icons.Rounded.Security,
                            iconBg = AppsTint,
                            iconTint = Color(0xFF22C55E),
                            onClick = { }
                        )
                        HorizontalDivider(color = BorderLight)
                        SettingsItem(
                            title = "Rate ShareIt",
                            icon = Icons.Rounded.StarOutline,
                            iconBg = FoldersTint,
                            iconTint = Color(0xFFEF4444),
                            onClick = { }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
