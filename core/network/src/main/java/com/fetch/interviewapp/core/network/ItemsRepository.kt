package com.fetch.interviewapp.core.network

import com.fetch.core.model.NetworkItem

/**
 * interface for fetching items
 */
interface ItemsRepository {
    suspend fun getItems(): List<NetworkItem>
}