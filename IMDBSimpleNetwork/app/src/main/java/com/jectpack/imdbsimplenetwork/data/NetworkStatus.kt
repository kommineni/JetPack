package com.jectpack.imdbsimplenetwork.data

sealed class NetworkStatus<out T> {
 object Loading : NetworkStatus<Nothing>()
 data class Failure(val error: String, val exception: Throwable? = null ) : NetworkStatus<Nothing>()
 data class Success<out T>(val data: T) : NetworkStatus<T>()
}