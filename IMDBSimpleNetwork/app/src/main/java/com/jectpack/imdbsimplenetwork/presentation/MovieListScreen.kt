package com.jectpack.imdbsimplenetwork.presentation

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jectpack.imdbsimplenetwork.data.NetworkStatus
import com.jectpack.imdbsimplenetwork.viewmodel.MoviesViewModel

@Composable
fun MovieList(
    modifier: Modifier,
    context: Context
){
    val moviesViewModel:MoviesViewModel = remember {  MoviesViewModel(context)}
    val movieState by moviesViewModel.movieState.collectAsState()


    when(movieState){
            is NetworkStatus.Loading ->{
                Box(
                modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            is NetworkStatus.Success ->{
                val moviesInfo = (movieState as NetworkStatus.Success).data
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 60.dp)
                ) {
                    val list = moviesInfo.data.mainSearch.edges
                    items(list){ item ->
                        MovieCard(item)
                    }
                }
            }
            is NetworkStatus.Failure -> {
            }
        }


}