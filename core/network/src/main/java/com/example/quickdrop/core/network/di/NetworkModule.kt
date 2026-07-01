package com.example.quickdrop.core.network.di

import com.example.quickdrop.core.network.socket.SocketClient
import com.example.quickdrop.core.network.socket.impl.SocketClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Binds
    @Singleton
    abstract fun bindSocketClient(impl: SocketClientImpl): SocketClient
}
