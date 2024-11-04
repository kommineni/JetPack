package com.jectpack.imdbmovie.data.repository.factory

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jectpack.imdbmovie.data.repository.MovieDetailInfoRepository
import com.jectpack.imdbmovie.viewmodel.MoviesViewModel

class MovieDetailInfoViewModelFactory(
    private val movieDetailsInfoRepository: MovieDetailInfoRepository,
    private val context: Context
) : ViewModelProvider.Factory {
    @SuppressLint("SuspiciousIndentation")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(movieDetailsInfoRepository, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
