package com.dev0.deliveryfood.feature_food.domain.repository

import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

class FoodRepository() {

    val dbR = AppDb.db.readableDatabase


    fun getById(id: Int): Food {
        val projection = arrayOf("id", "name", "description", "image", "qualification", "price", "restaurant", "restaurantName")
        var selection = "id = ?"
        var idS = id.toString()
        var selectionArgs = arrayOf(idS)
        val cursor = dbR.query(
            "food",
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        var foodF = Food()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val image = getString(getColumnIndexOrThrow("image"))
                val qualification = getString(getColumnIndexOrThrow("qualification"))
                val price = getDouble(getColumnIndexOrThrow("price"))
                val restaurant = getLong(getColumnIndexOrThrow("restaurant"))
                val restaurantName = getString(getColumnIndexOrThrow("restaurantName"))


                var food = Food(
                    id = id.toInt(),
                    name = name,
                    description = description,
                    image = image,
                    qualification = qualification,
                    restaurant = restaurant.toInt(),
                    restaurantName = restaurantName,
                    price = price,
                )

                foodF = food
            }
        }
        cursor.close()
        return foodF
    }

    fun getRestaurantById(id: Int): Restaurant {
        val projection = arrayOf("id", "name", "description", "district", "image", "qualification")
        var selection = "id = ?"
        var idS = id.toString()
        var selectionArgs = arrayOf(idS)
        val cursor = dbR.query(
            "restaurant",
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        var restaurantF = Restaurant()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val district = getString(getColumnIndexOrThrow("district"))
                val image = getString(getColumnIndexOrThrow("image"))
                val qualification = getString(getColumnIndexOrThrow("qualification"))


                var restaurant = Restaurant(
                    id = id.toInt(),
                    name = name,
                    description = description,
                    district = district,
                    image = image,
                    qualification = qualification
                )


                restaurantF = restaurant
            }
        }
        cursor.close()
        return restaurantF
    }

    fun getAll(): List<Food> {
        val projection = arrayOf("id", "name", "description", "image", "qualification", "price", "restaurant", "restaurantName")

        val cursor = dbR.query(
            "food",
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val list = ArrayList<Food>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val image = getString(getColumnIndexOrThrow("image"))
                val qualification = getString(getColumnIndexOrThrow("qualification"))
                val price = getDouble(getColumnIndexOrThrow("price"))
                val restaurant = getLong(getColumnIndexOrThrow("restaurant"))
                val restaurantName = getString(getColumnIndexOrThrow("restaurantName"))


                var food = Food(
                    id = id.toInt(),
                    name = name,
                    description = description,
                    image = image,
                    qualification = qualification,
                    restaurant = restaurant.toInt(),
                    restaurantName = restaurantName,
                    price = price,
                )

                list.add(food)
            }
        }
        cursor.close()
        return list
    }

    fun getAllByRestaurantId(idR: String): List<Food> {
        val projection = arrayOf("id", "name", "description", "image", "qualification", "price", "restaurant", "restaurantName")

        val cursor = dbR.query(
            "food",
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val list = ArrayList<Food>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val image = getString(getColumnIndexOrThrow("image"))
                val qualification = getString(getColumnIndexOrThrow("qualification"))
                val price = getDouble(getColumnIndexOrThrow("price"))
                val restaurant = getLong(getColumnIndexOrThrow("restaurant"))
                val restaurantName = getString(getColumnIndexOrThrow("restaurantName"))


                var food = Food(
                    id = id.toInt(),
                    name = name,
                    description = description,
                    image = image,
                    qualification = qualification,
                    restaurant = restaurant.toInt(),
                    restaurantName = restaurantName,
                    price = price,
                )

                list.add(food)
            }
        }
        cursor.close()

        var listF = ArrayList<Food>()

        for( item in list){
            if(item.restaurant == idR.toInt()){
                listF.add(item)
            }
        }

        return listF
    }

}