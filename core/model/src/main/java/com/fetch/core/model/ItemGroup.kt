package com.fetch.core.model

/**
 * model representing a group of items with the same listId
 */
data class ItemGroup(
    val listId: Int,
    val items: List<Item>
)