package com.example.quickdrop.core.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.plugins.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class TransferHttpClient {
    private val client = HttpClient(CIO)

    fun sendFile(file: File, ipAddress: String): Flow<Float> = flow {
        client.post("http://$ipAddress:8080/upload") {
            setBody(file.readBytes())
            onUpload { bytesSent, totalBytes ->
                emit(bytesSent.toFloat() / totalBytes)
            }
        }
    }
}
