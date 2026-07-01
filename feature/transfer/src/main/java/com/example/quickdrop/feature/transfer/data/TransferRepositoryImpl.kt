package com.example.quickdrop.feature.transfer.data

import android.net.Uri
import com.example.quickdrop.core.network.socket.SocketClient
import com.example.quickdrop.feature.transfer.domain.TransferRepository
import com.example.quickdrop.feature.transfer.domain.TransferStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TransferRepositoryImpl @Inject constructor(
    private val socketClient: SocketClient // Will be injected via Hilt
) : TransferRepository {
    override fun sendFile(fileUri: Uri, targetAddress: String): Flow<TransferStatus> = flow {
        emit(TransferStatus.Progress(0, 100, 0.0, "sample_video.mp4"))
        
        // Simulated chunked transfer using socket client
        socketClient.connect(targetAddress, 8888)
        
        delay(1000)
        emit(TransferStatus.Progress(50, 100, 5.0, "sample_video.mp4"))
        
        delay(1000)
        socketClient.close()
        emit(TransferStatus.Success)
    }

    override fun receiveFile(): Flow<TransferStatus> = flow {
        emit(TransferStatus.Idle)
    }
}
