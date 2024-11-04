package com.jectpack.imdbmovie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jectpack.imdbmovie.data.network.NetworkStatus
import com.jectpack.imdbmovie.data.network.model.MovieDetialInfo
import com.jectpack.imdbmovie.data.repository.MovieDetailInfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val movieDetailInfoRepository: MovieDetailInfoRepository,
    private val context: Context
) : ViewModel() {
    private val _movieState =
        MutableStateFlow<NetworkStatus<MovieDetialInfo>>(NetworkStatus.Loading)
    val movieState  = _movieState.asStateFlow()

    init {
        getMovies("ALL")
    }

    private fun getMovies(searchTerm: String) {
        viewModelScope.launch {
            movieDetailInfoRepository
                .getMovies(searchTerm , context)
                .catch {
                    _movieState.value =
                        NetworkStatus.Failure(it.localizedMessage ?: "Unknown Error")
                }
                .collect { result ->
                    _movieState.value = result
                }
        }
    }
}