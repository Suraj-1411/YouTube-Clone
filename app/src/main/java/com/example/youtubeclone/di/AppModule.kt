package com.example.youtubeclone.di

import com.example.youtubeclone.data.service.RemoteService
import com.example.youtubeclone.data.service.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRemoteService(): RemoteService = RemoteService()

    @Singleton
    @Provides
    fun providesRepository(service : RemoteService) : Repository = Repository(service)

}