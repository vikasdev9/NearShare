package com.example.quickdrop.core.network

import com.example.quickdrop.core.domain.DiscoveryRepository
import com.example.quickdrop.core.model.DeviceInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.jmdns.JmDNS
import javax.jmdns.ServiceEvent
import javax.jmdns.ServiceListener
import java.net.InetAddress

class DesktopMdnsService : DiscoveryRepository, ServiceListener {
    private val jmdns: JmDNS by lazy { JmDNS.create(InetAddress.getLocalHost()) }
    private val _devices = MutableStateFlow<List<DeviceInfo>>(emptyList())

    override fun getDiscoveredDevices(): Flow<List<DeviceInfo>> = _devices

    fun startDiscovery() {
        jmdns.addServiceListener("_quickdrop._tcp.local.", this)
    }

    override fun serviceAdded(event: ServiceEvent) {
        jmdns.getServiceInfo(event.type, event.name)
    }

    override fun serviceRemoved(event: ServiceEvent) {
        // Remove from _devices
    }

    override fun serviceResolved(event: ServiceEvent) {
        val info = DeviceInfo(
            id = event.info.name,
            name = event.info.name,
            ipAddress = event.info.inetAddresses.firstOrNull()?.hostAddress ?: ""
        )
        _devices.value = _devices.value + info
    }
}
