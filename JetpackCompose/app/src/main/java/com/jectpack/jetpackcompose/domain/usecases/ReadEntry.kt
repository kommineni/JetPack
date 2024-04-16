package com.jectpack.jetpackcompose.domain.usecases

import com.jectpack.jetpackcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadEntry(
    private  val localUserManager: LocalUserManager) {
    operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}