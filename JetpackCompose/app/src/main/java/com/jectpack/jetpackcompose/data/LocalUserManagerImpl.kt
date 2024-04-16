package com.jectpack.jetpackcompose.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.jectpack.jetpackcompose.domain.manager.LocalUserManager
import com.jectpack.jetpackcompose.utils.Constants
import com.jectpack.jetpackcompose.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.datastore.edit { prefs ->
            prefs[PrefsKeys.APP_ENTRY] = true
        }
    }
    override fun readAppEntry(): Flow<Boolean> {
       return context.datastore.data.map { prefs ->
           prefs[PrefsKeys.APP_ENTRY] ?: false
        }
    }
}

 private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PrefsKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}