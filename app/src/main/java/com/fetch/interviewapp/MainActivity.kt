package com.fetch.interviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme.colorScheme
import com.fetch.interviewapp.core.domain.GetFilteredItemsUseCase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get dependencies from Application
        val application = application as FetchInterviewApplication
        val repository = application.itemsRepository

        // Create use case
        val getFilteredItemsUseCase = GetFilteredItemsUseCase(repository)

        setContent {
            FetchInterviewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    // Create ViewModel factory
                    val viewModel = viewModel {
                        ItemListViewModel(getFilteredItemsUseCase)
                    }

                    // Show the items list screen
                    ItemListScreen(viewModel = viewModel)
                }
            }
        }
    }
}