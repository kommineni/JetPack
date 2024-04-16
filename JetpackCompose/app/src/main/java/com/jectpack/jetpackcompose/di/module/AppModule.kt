package com.jectpack.jetpackcompose.di.module

import android.app.Application
import com.jectpack.jetpackcompose.data.LocalUserManagerImpl
import com.jectpack.jetpackcompose.domain.manager.LocalUserManager
import com.jectpack.jetpackcompose.domain.usecases.AppEntryUseCases
import com.jectpack.jetpackcompose.domain.usecases.ReadEntry
import com.jectpack.jetpackcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalManager(
        context: Application
    ): LocalUserManager = LocalUserManagerImpl(context = context)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager = localUserManager),
        readEntry = ReadEntry(localUserManager = localUserManager)
    )
}