package com.jectpack.imdbmovie.data.network

sealed class NetworkStatus<out T> {
    data class Success<out T>(val data: T) : NetworkStatus<T>()
    data class Failure(val message: String, val exception:Throwable ? = null): NetworkStatus<Nothing>()
    object Loading:NetworkStatus<Nothing>()
}