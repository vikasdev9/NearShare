package com.example.quickdrop.core.network.socket

interface SocketClient {
    suspend fun connect(address: String, port: Int)
    suspend fun send(data: ByteArray)
    suspend fun close()
}
