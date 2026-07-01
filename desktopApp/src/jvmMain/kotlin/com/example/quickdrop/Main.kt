package com.example.quickdrop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.quickdrop.di.initKoin
import com.example.quickdrop.ui.home.HomeScreen
import com.example.quickdrop.ui.theme.QuickDropTheme
import com.example.quickdrop.platform.TrayIconManager
import org.koin.compose.KoinContext

fun main() = application {
    val koin = initKoin()

    val trayIconManager = TrayIconManager(
        onOpen = { /* Bring window to front */ },
        onExit = { exitApplication() }
    )
    trayIconManager.setup()

    Window(
        onCloseRequest = ::exitApplication,
        title = "QuickDrop Desktop",
    ) {
        KoinContext {
            QuickDropTheme {
                HomeScreen()
            }
        }
    }
}
