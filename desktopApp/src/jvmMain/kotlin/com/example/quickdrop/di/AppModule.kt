package com.example.quickdrop.di

import com.example.quickdrop.ui.discovery.DiscoveryViewModel
import com.example.quickdrop.core.network.DesktopMdnsService
import com.example.quickdrop.core.network.TransferHttpServer
import com.example.quickdrop.core.network.TransferHttpClient
import com.example.quickdrop.core.domain.DiscoveryRepository
import com.example.quickdrop.core.domain.TransferRepository
import com.example.quickdrop.core.database.RoomHistoryRepository
import com.example.quickdrop.core.database.getDatabaseBuilder
import com.example.quickdrop.core.domain.HistoryRepository
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    // ViewModels (Plain classes)
    factory { DiscoveryViewModel(get()) }
    
    // Network
    single<DiscoveryRepository> { DesktopMdnsService() }
    single { TransferHttpServer() }
    single { TransferHttpClient() }
    
    // Database
    single { getDatabaseBuilder() }
    single<HistoryRepository> { RoomHistoryRepository(get()) }
}

fun initKoin() = startKoin {
    modules(appModule)
}.koin
