package com.example.quickdrop.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM transfer_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<TransferHistoryEntity>>

    @Insert
    suspend fun insert(entity: TransferHistoryEntity)
}
