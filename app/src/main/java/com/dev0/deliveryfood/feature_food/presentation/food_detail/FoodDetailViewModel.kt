package com.dev0.deliveryfood.feature_food.presentation.food_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.dev0.deliveryfood.feacture_cart.domain.model.OrderDetail
import com.dev0.deliveryfood.feacture_cart.presentation.cart.CartViewModel
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodsState
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

class FoodDetailViewModel {
    private val repository =  FoodRepository()
    private val _state = mutableStateOf(FoodDetailState())
    val state: State<FoodDetailState> = _state


    fun getFoodById(id: Int) {
        var result: Food = repository.getById(id)
        var resultR: Restaurant = repository.getRestaurantById(id)

        _state.value = state.value.copy(
            food = result,
            restaurant = resultR.name
        )
    }

    fun addToOrder(cant: Int) {
        Log.e("SE llamo", "Si")
        var newOrderDetail = OrderDetail(
            quantity = cant,
            total = cant*state.value.food.price,
            food = state.value.food,
            ordered = state.value.food.id,
            restaurantName = state.value.restaurant,
            restaurant = state.value.food.restaurant,
            id = 1
        )

        CartViewModel.actualOrder.total+=(cant*state.value.food.price)
        CartViewModel.actualOrder.foods.add(newOrderDetail)
    }
}