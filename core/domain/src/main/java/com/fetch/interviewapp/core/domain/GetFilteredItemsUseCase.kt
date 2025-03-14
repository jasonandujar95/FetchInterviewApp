package com.fetch.interviewapp.core.domain

import com.fetch.core.model.Item
import com.fetch.core.model.ItemGroup
import com.fetch.interviewapp.core.network.ItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * use case that returns a flow of filtered and sorted items
 */
class GetFilteredItemsUseCase @Inject constructor(
    val repository: ItemsRepository
) {

    /**
     * gets items from the repository, then filters out null/blank names,
     * groups by listId, and sorts by id
     */
    operator fun invoke(): Flow<Result<List<ItemGroup>>> = flow {
        try {
            val networkItems = repository.getItems()

            // filter out items with null or blank names
            val filteredItems = networkItems
                .filter { !it.name.isNullOrBlank() }
                .map { Item(it.id, it.listId, it.name!!) }

            // group items by listId
            val groupedItems = filteredItems
                .groupBy { it.listId }
                .map { (listId, items) ->
                    // sort items by name within each group
                    val sortedItems = items.sortedBy {
                        // use number if possible for better sorting
                        val nameWithoutPrefix = it.name.replace("Item ", "")
                        nameWithoutPrefix.toIntOrNull() ?: Int.MAX_VALUE
                    }
                    ItemGroup(listId, sortedItems)
                }
                // Finally sort groups by listId
                .sortedBy { it.listId }

            emit(Result.success(groupedItems))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}