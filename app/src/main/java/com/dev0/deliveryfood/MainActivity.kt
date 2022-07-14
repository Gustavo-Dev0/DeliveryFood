package com.dev0.deliveryfood

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import com.dev0.deliveryfood.core.data.repository.Theme
import com.dev0.deliveryfood.core.data.repository.UserPreferencesRepository
import com.dev0.deliveryfood.core.presentation.MainScreen
import com.dev0.deliveryfood.ui.theme.DeliveryFoodTheme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val USER_PREFERENCES_NAME = "user_preferences"

private val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var userPreferencesRepository: UserPreferencesRepository

    private val appThemeState = mutableStateOf(Theme.DEFAULT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userPreferencesRepository = UserPreferencesRepository(dataStore)
        recoverFromDataStore()
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful){
                    Log.e("FCM Notify", "ERROR REGISTRANDO TOKEN", task.exception)
                    return@OnCompleteListener
                }
                val token: String? = task.result
                Log.e("FCM Notify", token, task.exception)
                //Toast.makeText(this, token, Toast.LENGTH_SHORT).show()

            })
        Firebase.messaging.subscribeToTopic("foods")
            .addOnCompleteListener { task ->
                var msg = "Subscribed"
                if (!task.isSuccessful) {
                    msg = "Subscribe failed"
                }
                Log.d("MainActivity", msg)
                //Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }


        setContent {

            DeliveryFoodTheme(
                darkTheme = false,
                appTheme = appThemeState.value
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(appThemeState){
                        lifecycleScope.launch{
                            userPreferencesRepository.updateAppTheme(appThemeState.value)
                        }
                    }

                }
            }
        }
    }

    private fun recoverFromDataStore() {
        lifecycleScope.launch{
            userPreferencesRepository.userPreferencesFlow.collect { userPreferences ->
                appThemeState.value = userPreferences.appTheme

            }
        }
    }

}