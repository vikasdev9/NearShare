package com.example.quickdrop.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickdrop.core.designsystem.theme.ShareItBlueStart
import com.example.quickdrop.core.designsystem.theme.SlateGray

enum class NavDestination {
    HOME, HISTORY, CONNECT, PROFILE
}

@Composable
fun BottomNavBar(
    currentDestination: NavDestination,
    onDestinationClick: (NavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    // Floating look with padding and large rounded corners
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp)
            .navigationBarsPadding()
    ) {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(32.dp),
            shadowElevation = 12.dp,
            modifier = Modifier.fillMaxWidth().height(80.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavItem(
                    label = "Home",
                    icon = Icons.Rounded.Home,
                    isSelected = currentDestination == NavDestination.HOME,
                    onClick = { onDestinationClick(NavDestination.HOME) }
                )
                NavItem(
                    label = "History",
                    icon = Icons.Rounded.History,
                    isSelected = currentDestination == NavDestination.HISTORY,
                    onClick = { onDestinationClick(NavDestination.HISTORY) }
                )
                NavItem(
                    label = "Connect",
                    icon = Icons.Rounded.Wifi,
                    isSelected = currentDestination == NavDestination.CONNECT,
                    onClick = { onDestinationClick(NavDestination.CONNECT) }
                )
                NavItem(
                    label = "Profile",
                    icon = Icons.Rounded.Person,
                    isSelected = currentDestination == NavDestination.PROFILE,
                    onClick = { onDestinationClick(NavDestination.PROFILE) }
                )
            }
        }
    }
}

@Composable
private fun NavItem(
    label: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (isSelected) ShareItBlueStart else SlateGray

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) ShareItBlueStart.copy(alpha = 0.12f) else Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(26.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = contentColor
            )
        }
    }
}
