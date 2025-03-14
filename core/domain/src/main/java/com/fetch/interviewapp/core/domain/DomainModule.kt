package com.fetch.interviewapp.core.domain

import com.fetch.interviewapp.core.network.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetFilteredItemsUseCase(repository: ItemsRepository): GetFilteredItemsUseCase {
        return GetFilteredItemsUseCase(repository)
    }
}