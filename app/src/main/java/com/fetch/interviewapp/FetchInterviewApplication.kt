package com.fetch.interviewapp

import android.app.Application
import com.fetch.interviewapp.core.network.FetchApiService
import com.fetch.interviewapp.core.network.FetchApiServiceImpl
import com.fetch.interviewapp.core.network.ItemsRepository
import com.fetch.interviewapp.core.network.ItemsRepositoryImpl
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FetchInterviewApplication : Application() {

    // API service singleton
    val apiService: FetchApiService by lazy {
        FetchApiServiceImpl().apiService
    }

    // Repository singleton
    val itemsRepository: ItemsRepository by lazy {
        ItemsRepositoryImpl(apiService)
    }
}