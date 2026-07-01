package com.example.quickdrop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickdrop.feature.home.presentation.HomeRoute
import com.example.quickdrop.feature.transfer.presentation.TransferRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeRouteDestination

@Serializable
data class TransferRouteData(val deviceAddress: String)

@Composable
fun QuickDropNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeRouteDestination) {
        composable<HomeRouteDestination> {
            HomeRoute(onTransferClick = { addr -> navController.navigate(TransferRouteData(addr)) })
        }
        composable<TransferRouteData> {
            TransferRoute(onBackClick = { navController.popBackStack() })
        }
    }
}
