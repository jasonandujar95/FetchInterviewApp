package com.fetch.interviewapp.core.itemlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.core.model.ItemGroup
import com.fetch.interviewapp.core.domain.GetFilteredItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * UI state for the items list screen
 */
data class ItemListUiState(
    val isLoading: Boolean = false,
    val itemGroups: List<ItemGroup> = emptyList(),
    val error: String? = null
)

/**
 * ViewModel for the items list screen
 */
@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val getFilteredItemsUseCase: GetFilteredItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ItemListUiState(isLoading = true))
    val uiState: StateFlow<ItemListUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    fun loadItems() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            getFilteredItemsUseCase().collect { result ->
                result.fold(
                    onSuccess = { itemGroups ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                itemGroups = itemGroups,
                                error = null
                            )
                        }
                    },
                    onFailure = { error ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = error.message ?: "Unknown error occurred"
                            )
                        }
                    }
                )
            }
        }
    }
}