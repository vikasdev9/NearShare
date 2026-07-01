package com.example.quickdrop.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quickdrop.core.database.dao.HistoryDao
import com.example.quickdrop.core.database.model.TransferHistoryEntity

@Database(entities = [TransferHistoryEntity::class], version = 1)
abstract class QuickDropDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}
