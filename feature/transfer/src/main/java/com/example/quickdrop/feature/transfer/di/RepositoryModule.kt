package com.example.quickdrop.feature.transfer.di

import com.example.quickdrop.feature.transfer.data.TransferRepositoryImpl
import com.example.quickdrop.feature.transfer.domain.TransferRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTransferRepository(
        transferRepositoryImpl: TransferRepositoryImpl
    ): TransferRepository
}
