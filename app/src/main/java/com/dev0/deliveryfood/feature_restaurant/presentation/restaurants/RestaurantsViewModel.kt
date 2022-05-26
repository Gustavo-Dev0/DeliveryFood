package com.dev0.deliveryfood.feature_restaurant.presentation.restaurants

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodsState
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import com.dev0.deliveryfood.feature_restaurant.domain.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class RestaurantsViewModel() {

    private val repository =  RestaurantRepository()
    private val _state = mutableStateOf(RestaurantsState())
    val state: State<RestaurantsState> = _state

    init {
        getRestaurants()
    }


    private fun getRestaurants() {

        var result: List<Restaurant> = repository.getAll()

        val fo = Restaurant(
            id = 1,
            name = "Zig Zag R",
            description = "Salud y seguridad: Se requiere el uso de mascarilla · Se requiere una revisión de temperatura · El personal usa mascarillas · El personal se somete a revisiones de temperatura · Desinfección de superficies obligatoria por parte del personal después de cada visita",
            qualification = "1.5",
            image = "https://lh5.googleusercontent.com/p/AF1QipPR94bXCyckfJ0w3McZFfO9bthp04g-etcJJe2Q=w72-h72-n-k-no",
            district = "Arequipa - Cercado"
        )

        val f = mutableListOf(fo)
        val restaurants = f
        /*_state.value = state.value.copy(
            restaurants = restaurants
        )*/
        _state.value = state.value.copy(
            restaurants = result
        )
    }
}