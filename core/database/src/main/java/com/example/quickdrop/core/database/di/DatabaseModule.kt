package com.example.quickdrop.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.quickdrop.core.database.QuickDropDatabase
import com.example.quickdrop.core.database.dao.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): QuickDropDatabase {
        return Room.databaseBuilder(
            context,
            QuickDropDatabase::class.java,
            "quickdrop.db"
        ).build()
    }

    @Provides
    fun provideHistoryDao(db: QuickDropDatabase): HistoryDao = db.historyDao()
}
