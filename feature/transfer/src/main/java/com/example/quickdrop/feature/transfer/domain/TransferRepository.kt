package com.example.quickdrop.feature.transfer.domain

import android.net.Uri
import kotlinx.coroutines.flow.Flow

interface TransferRepository {
    fun sendFile(fileUri: Uri, targetAddress: String): Flow<TransferStatus>
    fun receiveFile(): Flow<TransferStatus>
}

sealed interface TransferStatus {
    data object Idle : TransferStatus
    data class Progress(
        val bytesSent: Long,
        val totalBytes: Long,
        val speed: Double,
        val fileName: String
    ) : TransferStatus
    data object Success : TransferStatus
    data class Error(val message: String) : TransferStatus
}
