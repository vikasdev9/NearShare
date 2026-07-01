package com.example.quickdrop.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TransferHistoryEntity::class], version = 1)
abstract class QuickDropDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}
