package com.fetch.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an item as returned by the API
 */
@Serializable
data class NetworkItem(
    @SerialName("id") val id: Int,
    @SerialName("listId") val listId: Int,
    @SerialName("name") val name: String? = null
)