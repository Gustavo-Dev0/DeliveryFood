package com.dev0.deliveryfood.feature_food.domain.model


data class Food (
    val name: String = "",
    val description: String = "",
    val restaurant : Int = 0,
    val restaurantName : String = "",
    val qualification : String = "",
    val image : String = "",
    val price : Double = 0.0,
    val id: Int = 0
)