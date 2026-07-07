package com.example.quickdrop.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quickdrop.feature.discovery.presentation.DiscoveryRoute
import com.example.quickdrop.feature.history.presentation.HistoryRoute
import com.example.quickdrop.feature.home.HomeRoute
import com.example.quickdrop.feature.home.components.BottomNavBar
import com.example.quickdrop.feature.home.components.NavDestination
import com.example.quickdrop.feature.onboarding.OnboardingScreen
import com.example.quickdrop.feature.onboarding.OnboardingViewModel
import com.example.quickdrop.feature.onboarding.SplashScreen
import com.example.quickdrop.feature.settings.presentation.ProfileRoute
import com.example.quickdrop.feature.transfer.presentation.TransferRoute
import kotlinx.serialization.Serializable

@Serializable
object SplashRoute

@Serializable
object OnboardingRoute

@Serializable
object HomeRouteDestination

@Serializable
object HistoryRouteDestination

@Serializable
object ConnectRouteDestination

@Serializable
object ProfileRouteDestination

@Serializable
data class TransferRouteData(val deviceAddress: String)

@Composable
fun QuickDropNavHost(
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val hasSeenOnboarding by viewModel.hasSeenOnboarding.collectAsState(initial = null)
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomBar = currentDestination?.route?.let { route ->
        route.contains("Home") || route.contains("History") || route.contains("Connect") || route.contains("Profile")
    } ?: false

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(
                    currentDestination = when {
                        currentDestination?.hierarchy?.any { it.route?.contains("Home") == true } == true -> NavDestination.HOME
                        currentDestination?.hierarchy?.any { it.route?.contains("History") == true } == true -> NavDestination.HISTORY
                        currentDestination?.hierarchy?.any { it.route?.contains("Connect") == true } == true -> NavDestination.CONNECT
                        currentDestination?.hierarchy?.any { it.route?.contains("Profile") == true } == true -> NavDestination.PROFILE
                        else -> NavDestination.HOME
                    },
                    onDestinationClick = { destination ->
                        val route = when (destination) {
                            NavDestination.HOME -> HomeRouteDestination
                            NavDestination.HISTORY -> HistoryRouteDestination
                            NavDestination.CONNECT -> ConnectRouteDestination
                            NavDestination.PROFILE -> ProfileRouteDestination
                        }
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SplashRoute,
            modifier = Modifier.padding(if (showBottomBar) innerPadding else PaddingValues())
        ) {
            composable<SplashRoute> {
                SplashScreen(
                    onNavigateNext = {
                        if (hasSeenOnboarding == true) {
                            navController.navigate(HomeRouteDestination) {
                                popUpTo(SplashRoute) { inclusive = true }
                            }
                        } else {
                            navController.navigate(OnboardingRoute) {
                                popUpTo(SplashRoute) { inclusive = true }
                            }
                        }
                    }
                )
            }
            composable<OnboardingRoute> {
                OnboardingScreen(
                    onComplete = {
                        viewModel.completeOnboarding()
                        navController.navigate(HomeRouteDestination) {
                            popUpTo(OnboardingRoute) { inclusive = true }
                        }
                    }
                )
            }
            composable<HomeRouteDestination> {
                HomeRoute(
                    onSendClick = { navController.navigate(ConnectRouteDestination) },
                    onReceiveClick = { navController.navigate(ConnectRouteDestination) },
                    onCategoryClick = { _ -> },
                    onSeeAllClick = { navController.navigate(HistoryRouteDestination) },
                    onSettingsClick = { navController.navigate(ProfileRouteDestination) }
                )
            }
            composable<HistoryRouteDestination> {
                HistoryRoute()
            }
            composable<ConnectRouteDestination> {
                DiscoveryRoute(onBackClick = { navController.popBackStack() })
            }
            composable<ProfileRouteDestination> {
                ProfileRoute()
            }
            composable<TransferRouteData> {
                TransferRoute(onBackClick = { navController.popBackStack() })
            }
        }
    }
}
