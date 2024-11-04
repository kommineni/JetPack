package com.jectpack.imdbmovie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jectpack.imdbmovie.data.network.NetworkStatus
import com.jectpack.imdbmovie.data.repository.MovieDetailInfoRepository
import com.jectpack.imdbmovie.data.repository.factory.MovieDetailInfoViewModelFactory
import com.jectpack.imdbmovie.ui.activity.MainActivity
import com.jectpack.imdbmovie.viewmodel.MoviesViewModel

@Composable
fun HomeScreen(mainActivity: MainActivity) {
    val repository = remember { MovieDetailInfoRepository() }
    val moviesViewModel: MoviesViewModel = viewModel(factory = MovieDetailInfoViewModelFactory(repository, context = mainActivity))
    val movieState by moviesViewModel.movieState.collectAsState()
    when (movieState) {
        is NetworkStatus.Loading -> {
            CircularProgressIndicator()
        }

        is NetworkStatus.Success -> {
            val moviesInfo = (movieState as NetworkStatus.Success).data
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = " This is first Movie in the list ${moviesInfo.data.mainSearch.edges.first().node.entity.titleText}"
                )
            }
        }

        is NetworkStatus.Failure -> {
            val error = (movieState as NetworkStatus.Failure).message
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error $error"
                )
            }
        }
    }
}