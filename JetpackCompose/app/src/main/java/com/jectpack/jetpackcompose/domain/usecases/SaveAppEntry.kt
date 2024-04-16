package com.jectpack.jetpackcompose.domain.usecases

import com.jectpack.jetpackcompose.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}