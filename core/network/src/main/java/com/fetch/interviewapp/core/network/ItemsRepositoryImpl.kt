package com.fetch.interviewapp.core.network

import com.fetch.core.model.NetworkItem

/**
 * repository implementation that fetches items from the API
 */
class ItemsRepositoryImpl(
    private val apiService: FetchApiService
) : ItemsRepository {
    override suspend fun getItems(): List<NetworkItem> {
        return apiService.getItems()
    }
}