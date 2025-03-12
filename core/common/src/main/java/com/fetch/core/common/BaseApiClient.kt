package com.fetch.core.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Base class for API calls that provides error handling
 */
abstract class BaseApiClient(
    private val ioDispatcher: CoroutineContext = Dispatchers.IO
) {
    /**
     * Executes a suspend function safely with error handling
     */
    protected suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Result<T> = withContext(ioDispatcher) {
        try {
            Result.success(apiCall())
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}