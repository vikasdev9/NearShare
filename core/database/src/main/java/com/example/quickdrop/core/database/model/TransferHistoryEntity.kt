package com.example.quickdrop.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transfer_history")
data class TransferHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fileName: String,
    val fileSize: Long,
    val deviceName: String,
    val isIncoming: Boolean,
    val timestamp: Long = System.currentTimeMillis(),
    val status: String // COMPLETED, FAILED, CANCELLED
)
