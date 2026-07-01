package com.example.quickdrop.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quickdrop.core.database.model.TransferHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM transfer_history ORDER BY timestamp DESC")
    fun getAllHistory(): Flow<List<TransferHistoryEntity>>

    @Insert
    suspend fun insertHistory(history: TransferHistoryEntity)

    @Query("DELETE FROM transfer_history")
    suspend fun clearHistory()
}
