package com.dev0.deliveryfood

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import com.dev0.deliveryfood.core.data.repository.Theme
import com.dev0.deliveryfood.core.data.repository.UserPreferencesRepository
import com.dev0.deliveryfood.core.presentation.MainScreen
import com.dev0.deliveryfood.ui.theme.DeliveryFoodTheme
import dagger.hilt.android.AndroidEntryPoint

private const val USER_PREFERENCES_NAME = "user_preferences"

private val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var currentColor = Color.Yellow

    private lateinit var userPreferencesRepository: UserPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userPreferencesRepository = UserPreferencesRepository(dataStore)
        observeUIPreferences()

        setContent {


            DeliveryFoodTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }

        }
    }

    private fun observeUIPreferences() {
        userPreferencesRepository.userPreferencesFlow.asLiveData().observe(this) { userPreferences ->
            when(userPreferences.appTheme) {
                Theme.DEFAULT -> onDefaultMode()
                Theme.BLACK -> onBlackMode()
            }
        }
    }

    private fun onBlackMode() {

    }

    private fun onDefaultMode() {
        Log.e("THEME_DATASTORE", "DEFAULT IN DATA STORE")
    }


}
