package com.example.quickdrop.platform

import java.awt.*
import javax.swing.ImageIcon

class TrayIconManager(
    private val onOpen: () -> Unit,
    private val onExit: () -> Unit
) {
    fun setup() {
        if (!SystemTray.isSupported()) {
            println("SystemTray is not supported")
            return
        }

        val tray = SystemTray.getSystemTray()
        val popup = PopupMenu()

        val openItem = MenuItem("Open QuickDrop").apply {
            addActionListener { onOpen() }
        }
        val exitItem = MenuItem("Exit").apply {
            addActionListener { onExit() }
        }

        popup.add(openItem)
        popup.addSeparator()
        popup.add(exitItem)

        // Using a placeholder or loading from resources
        val image = ImageIcon(javaClass.getResource("/app_icon.ico")).image
        val trayIcon = TrayIcon(image, "QuickDrop", popup)
        trayIcon.isImageAutoSize = true

        try {
            tray.add(trayIcon)
        } catch (e: AWTException) {
            e.printStackTrace()
        }
    }
}
