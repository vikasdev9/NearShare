package com.example.quickdrop.ui.discovery

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Interface and models assumed to be in :core:domain and :core:model
import com.example.quickdrop.core.model.DeviceInfo
import com.example.quickdrop.core.domain.DiscoveryRepository

class DiscoveryViewModel(
    private val discoveryRepository: DiscoveryRepository
) {
    // Manually managed scope since we don't have androidx.lifecycle.ViewModel
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _uiState = MutableStateFlow(DiscoveryUiState())
    val uiState = _uiState.asStateFlow()

    fun startDiscovery() {
        viewModelScope.launch {
            discoveryRepository.getDiscoveredDevices().collect { devices ->
                _uiState.update { it.copy(devices = devices) }
            }
        }
    }

    fun onCleared() {
        viewModelScope.cancel()
    }
}

data class DiscoveryUiState(
    val devices: List<DeviceInfo> = emptyList(),
    val isScanning: Boolean = false
)
