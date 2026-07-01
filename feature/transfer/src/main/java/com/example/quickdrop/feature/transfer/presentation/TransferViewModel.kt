package com.example.quickdrop.feature.transfer.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickdrop.feature.transfer.domain.SendFileUseCase
import com.example.quickdrop.feature.transfer.domain.TransferStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransferViewModel @Inject constructor(
    private val sendFileUseCase: SendFileUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<TransferUiState>(TransferUiState.Idle)
    val uiState: StateFlow<TransferUiState> = _uiState.asStateFlow()

    fun startTransfer(uri: Uri, address: String) {
        viewModelScope.launch {
            sendFileUseCase(uri, address).collect { status ->
                _uiState.value = when (status) {
                    is TransferStatus.Progress -> {
                        val progress = status.bytesSent.toFloat() / status.totalBytes
                        TransferUiState.Transferring(
                            progress = progress,
                            speed = "${String.format("%.2f", status.speed)} MB/s",
                            fileName = status.fileName
                        )
                    }
                    TransferStatus.Success -> TransferUiState.Success
                    is TransferStatus.Error -> TransferUiState.Error(status.message)
                    TransferStatus.Idle -> TransferUiState.Idle
                }
            }
        }
    }
}

sealed interface TransferUiState {
    data object Idle : TransferUiState
    data class Transferring(
        val progress: Float,
        val speed: String,
        val fileName: String
    ) : TransferUiState
    data object Success : TransferUiState
    data class Error(val message: String) : TransferUiState
}
