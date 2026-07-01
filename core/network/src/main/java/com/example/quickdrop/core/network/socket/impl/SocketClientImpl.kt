package com.example.quickdrop.core.network.socket.impl

import com.example.quickdrop.core.network.socket.SocketClient
import javax.inject.Inject
import java.net.Socket

class SocketClientImpl @Inject constructor() : SocketClient {
    private var socket: Socket? = null

    override suspend fun connect(address: String, port: Int) {
        // Implementation logic for TCP socket connection
    }

    override suspend fun send(data: ByteArray) {
        socket?.getOutputStream()?.write(data)
    }

    override suspend fun close() {
        socket?.close()
    }
}
