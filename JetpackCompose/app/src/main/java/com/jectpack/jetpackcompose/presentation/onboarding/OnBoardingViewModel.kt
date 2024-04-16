package com.jectpack.jetpackcompose.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jectpack.jetpackcompose.domain.manager.LocalUserManager
import com.jectpack.jetpackcompose.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private  val appEntryUseCases: AppEntryUseCases
) : ViewModel(){

    fun onEvent(event: OnBoardingEvent){
        when(event){
            OnBoardingEvent.SaveAppEntry ->{
                saveEntry()
            }
        }

    }
    private fun saveEntry() {
        viewModelScope.launch{
            appEntryUseCases.saveAppEntry()
        }
    }
}