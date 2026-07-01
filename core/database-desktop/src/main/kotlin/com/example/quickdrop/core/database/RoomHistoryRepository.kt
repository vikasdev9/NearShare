package com.example.quickdrop.core.database

import com.example.quickdrop.core.domain.HistoryRepository
import com.example.quickdrop.core.model.FileItem
import com.example.quickdrop.core.model.TransferStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomHistoryRepository(
    private val database: QuickDropDatabase
) : HistoryRepository {

    override fun getHistory(): Flow<List<FileItem>> {
        return database.historyDao().getAll().map { entities ->
            entities.map { entity ->
                FileItem(
                    name = entity.fileName,
                    size = entity.fileSize,
                    // Map other fields as needed
                )
            }
        }
    }
}
