package com.fetch.interviewapp.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * API service implementation
 */
class FetchApiServiceImpl {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        isLenient = true
    }

    private val contentType = "application/json".toMediaType()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val apiService: FetchApiService = retrofit.create(FetchApiService::class.java)

    companion object {
        private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    }
}