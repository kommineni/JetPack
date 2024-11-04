package com.jectpack.imdbsimplenetwork.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jectpack.imdbsimplenetwork.data.NetworkStatus
import com.jectpack.imdbsimplenetwork.data.network.model.MovieDetailInfo
import com.jectpack.imdbsimplenetwork.data.repository.MoviesApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val context: Context
) : ViewModel() {
    val repository = MoviesApiRepo()
    private val _movieState =
        MutableStateFlow<NetworkStatus<MovieDetailInfo>>(NetworkStatus.Loading)
    val movieState  = _movieState.asStateFlow()

    init {
            getMovies()
        }

    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository
                .getMovieFromLocal(context)
                .catch {
                    _movieState.value =
                        NetworkStatus.Failure(it.localizedMessage ?: "Unknown Error")
                }.onCompletion { print("Flow completed") }
                .collect { result ->
                    _movieState.value = result
                    NetworkStatus.Success(result)
                }
        }
    }
}