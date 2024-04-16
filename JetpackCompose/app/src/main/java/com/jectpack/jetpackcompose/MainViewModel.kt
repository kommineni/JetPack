package com.jectpack.jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jectpack.jetpackcompose.domain.usecases.AppEntryUseCases
import com.jectpack.jetpackcompose.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel(){

    var splashScreenCondition by mutableStateOf(true)
        private  set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set
    init {
        appEntryUseCases.readEntry().onEach {shouldStartFromHomeScreen ->
            startDestination = if (shouldStartFromHomeScreen){
                Route.NewsNavigation.route
            }else
                Route.AppStartNavigation.route
            delay(200)
            splashScreenCondition = false
        }.launchIn(viewModelScope)
    }
}