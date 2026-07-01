package com.example.quickdrop.core.domain

import com.example.quickdrop.core.model.DeviceInfo
import kotlinx.coroutines.flow.Flow

interface DiscoveryRepository {
    fun getDiscoveredDevices(): Flow<List<DeviceInfo>>
}
