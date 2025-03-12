package com.fetch.interviewapp.core.network

import com.fetch.core.model.NetworkItem
import retrofit2.http.GET

/**
 * API service interface for network requests
 */
interface FetchApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<NetworkItem>
}