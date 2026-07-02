package com.example.quickdrop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickdrop.feature.home.HomeRoute
import com.example.quickdrop.feature.home.model.CategoryType
import com.example.quickdrop.feature.onboarding.OnboardingScreen
import com.example.quickdrop.feature.onboarding.OnboardingViewModel
import com.example.quickdrop.feature.onboarding.SplashScreen
import com.example.quickdrop.feature.transfer.presentation.TransferRoute
import kotlinx.serialization.Serializable

@Serializable
object SplashRoute

@Serializable
object OnboardingRoute

@Serializable
object HomeRouteDestination

@Serializable
data class TransferRouteData(val deviceAddress: String)

@Composable
fun QuickDropNavHost(
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val hasSeenOnboarding by viewModel.hasSeenOnboarding.collectAsState(initial = null)

    NavHost(navController = navController, startDestination = SplashRoute) {
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
                onSendClick = { /* Handle Send click */ },
                onReceiveClick = { /* Handle Receive click */ },
                onCategoryClick = { _ -> /* handle category click */ },
                onSeeAllClick = { /* handle see all */ },
                onSettingsClick = { /* handle settings click */ }
            )
        }
        composable<TransferRouteData> {
            TransferRoute(onBackClick = { navController.popBackStack() })
        }
    }
}
