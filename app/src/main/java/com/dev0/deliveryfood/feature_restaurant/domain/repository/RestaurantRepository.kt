package com.dev0.deliveryfood.feature_restaurant.domain.repository

import android.database.sqlite.SQLiteDatabase
import androidx.compose.ui.platform.LocalContext
import com.dev0.deliveryfood.core.data.DBHelper
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

class RestaurantRepository() {

    val dbR = AppDb.db.readableDatabase

    fun getAll(): List<Restaurant> {

        val projection = arrayOf("id", "name", "description", "district", "image", "qualification")

        val cursor = dbR.query(
            "restaurant",
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val list = ArrayList<Restaurant>()
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


                list.add(restaurant)
            }
        }
        cursor.close()
        return list
    }

}