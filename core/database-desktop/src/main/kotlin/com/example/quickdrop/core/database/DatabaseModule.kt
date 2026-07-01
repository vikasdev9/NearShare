package com.example.quickdrop.core.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

fun getDatabaseBuilder(): QuickDropDatabase {
    val dbFile = File(System.getProperty("user.home"), ".quickdrop/quickdrop.db")
    if (!dbFile.parentFile.exists()) {
        dbFile.parentFile.mkdirs()
    }
    return Room.databaseBuilder<QuickDropDatabase>(
        name = dbFile.absolutePath,
    )
    .setDriver(BundledSQLiteDriver())
    .build()
}
