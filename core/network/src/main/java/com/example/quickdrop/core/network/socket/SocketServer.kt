package com.example.quickdrop.core.network.socket

import kotlinx.coroutines.flow.Flow

interface SocketServer {
    fun startListening(port: Int): Flow<SocketEvent>
    suspend fun stop()
}

sealed interface SocketEvent {
    data class Connected(val remoteAddress: String) : SocketEvent
    data class DataReceived(val bytes: ByteArray) : SocketEvent
    data class Error(val message: String) : SocketEvent
}
