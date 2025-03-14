package com.fetch.interviewapp.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideFetchApiService(): FetchApiService {
        return FetchApiServiceImpl().apiService
    }

    @Provides
    @Singleton
    fun provideItemsRepository(apiService: FetchApiService): ItemsRepository {
        return ItemsRepositoryImpl(apiService)
    }
}