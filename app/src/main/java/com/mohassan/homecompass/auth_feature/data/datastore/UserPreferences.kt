package com.mohassan.homecompass.auth_feature.data.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mohassan.homecompass.auth_feature.data.remote.dto.RegisterRequestBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferences @Inject constructor(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "user_prefs")

    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_LOGGED_IN] ?: false
    }
    val isDonor: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_DONOR] ?: false
    }

    suspend fun setLoggedIn(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
        }
    }

    suspend fun setIsDonor(isDonor: Boolean) {
        try {
            context.dataStore.edit { preferences ->
                preferences[IS_DONOR] = isDonor
            }
        } catch (e: Exception) {
            Log.e("UserPreferences", "Error setting isDonor in DataStore", e)
        }
    }

    suspend fun saveUserData(userData: RegisterRequestBody) {
        context.dataStore.edit { preferences ->
            preferences[USER_FIRST_NAME] = userData.firstName
            preferences[USER_LAST_NAME] = userData.lastName
            preferences[USER_USERNAME] = userData.username
            preferences[USER_EMAIL] = userData.email
            // You can save other user data as well
        }
    }

    suspend fun getUserData(): RegisterRequestBody? {
        val data = context.dataStore.data.first()
        return if (data.contains(USER_FIRST_NAME) && data.contains(USER_LAST_NAME) &&
            data.contains(USER_USERNAME) && data.contains(USER_EMAIL)
        ) {
            RegisterRequestBody(
                data[USER_FIRST_NAME] ?: "My",
                data[USER_LAST_NAME] ?: "Name",
                data[USER_USERNAME] ?: "user",
                data[USER_EMAIL] ?: "example@email.com",
                "" // Password is not stored
            )
        } else {
            null
        }
    }

    companion object PreferencesKeys {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
        val USER_LAST_NAME = stringPreferencesKey("user_last_name")
        val USER_USERNAME = stringPreferencesKey("user_username")
        val USER_EMAIL = stringPreferencesKey("user_email")

        val IS_DONOR = booleanPreferencesKey("is_donor")
    }
}