package com.fetch.core.common

/**
 * A generic class that holds a value or an exception
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    companion object {
        fun <T> success(data: T): Result<T> = Success(data)
        fun error(exception: Throwable): Result<Nothing> = Error(exception)
    }
}

/**
 * Convert a nullable [T] to a [Result].
 */
fun <T> T?.toResult(): Result<T> {
    return if (this != null) {
        Result.Success(this)
    } else {
        Result.Error(NullPointerException("Result is null"))
    }
}