package com.dev0.deliveryfood


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.ui.platform.LocalContext
import com.dev0.deliveryfood.core.data.DBHelper
import com.dev0.deliveryfood.core.presentation.MainScreen
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.ui.theme.DeliveryFoodTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            AppDb.db = DBHelper(applicationContext)
            val db = AppDb.db.writableDatabase

            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            val defaultValue = resources.getInteger(R.integer.preference_file_keyD)
            val highScore = sharedPref.getInt(getString(R.string.preference_file_key), defaultValue)

            if(highScore == 0) {
                testInit(db)
            }


            /*DeliveryFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }*/
            MainScreen()
        }
    }

    private fun testInit(db: SQLiteDatabase?) {


        //Ingresar restaurantes
        val values = ContentValues().apply {
            put("name", "Dimas")
            put("description", "Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto")
            put("district", "Cercado")
            put("image", "https://lh5.googleusercontent.com/p/AF1QipNbp0qDeXyA6Ye4-5oDB5Q6eIqLqywmTXXqbb22=w72-h72-n-k-no")
            put("qualification", "5.0")
        }

        val values2 = ContentValues().apply {
            put("name", "Las Gringas")
            put("description", "Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.")
            put("district", "Cercado")
            put("image", "https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no")
            put("qualification", "4.0")
        }

        val values3 = ContentValues().apply {
            put("name", "Pasta Canteen")
            put("description", "Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto")
            put("district", "C. Puente Grau 300")
            put("image", "https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no")
            put("qualification", "3.0")
        }
        val newRowId = db?.insert("restaurant", null, values)
        Log.e("Agregado ", newRowId.toString())
        val newRowId2 = db?.insert("restaurant", null, values2)
        Log.e("Agregado ", newRowId2.toString())
        val newRowId3 = db?.insert("restaurant", null, values3)
        Log.e("Agregado ", newRowId3.toString())

        //Ingresar platos
        //R1
        val valuesF = ContentValues().apply {
            put("name", "Chupe de camarones")
            put("description", "Este es uno de los platos típicos de Arequipa y uno de los más servidos en las picanterías de esta ciudad. Es una sopa picante que combina entre sus ingredientes: camarones de río, papa amarilla, queso, leche, maíces y un aderezo de ají y huacatay que le da un sabor auténtico. Ideal para personas que disfrutan lo picante y son amantes de los camarones. ")
            put("price", 15.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Chupe-de-camarones-El-Comercio.jpg")
            put("restaurant", 1)
            put("restaurantName", "Dimas")
            put("qualification", "4.0")
        }
        val valuesF2 = ContentValues().apply {
            put("name", "Rocoto relleno")
            put("description", "Este es uno de los platos banderas de la Ciudad Blanca, que incluso ha logrado traspasar fronteras gracias a su exquisito sabor. Da honor a su nombre ya que su propuesta incluye un rocoto relleno de carne molida mezclada con guisantes, aceitunas, queso fresco y otras especies que hacen de éste un plato de sabor inigualable. Suele ir acompañado de pastel de papa, lo que provoca una combinación que te enamorará por completo. ")
            put("price", 10.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg")
            put("restaurant", 1)
            put("restaurantName", "Dimas")
            put("qualification", "5.0")
        }
        //R2
        val valuesF3 = ContentValues().apply {
            put("name", "Rocoto relleno")
            put("description", "Este es uno de los platos banderas de la Ciudad Blanca, que incluso ha logrado traspasar fronteras gracias a su exquisito sabor. Da honor a su nombre ya que su propuesta incluye un rocoto relleno de carne molida mezclada con guisantes, aceitunas, queso fresco y otras especies que hacen de éste un plato de sabor inigualable. Suele ir acompañado de pastel de papa, lo que provoca una combinación que te enamorará por completo. ")
            put("price", 8.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg")
            put("restaurant", 2)
            put("restaurantName", "Las Gringas")
            put("qualification", "3.0")
        }
        val valuesF4 = ContentValues().apply {
            put("name", "Adobo arequipeño")
            put("description", "De acuerdo con la tradición arequipeña este es un plato que se come los domingos. Preparado en base a lomo de cerdo con una salsa que combina ají molido, cebolla, chicha de jora y otros condimentos. Este plato se caracteriza por su tierna y jugosa carne y su consistencia espesa, además suele ir acompañado por pan. La definición de este plato es: picante y sabroso")
            put("price", 20.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Adobo-arequipeno-Abrecht.jpg")
            put("restaurant", 2)
            put("restaurantName", "Las Gringas")
            put("qualification", "7.0")
        }
        //R3
        val valuesF5 = ContentValues().apply {
            put("name", "Chupe de camarones")
            put("description", "Este es uno de los platos típicos de Arequipa y uno de los más servidos en las picanterías de esta ciudad. Es una sopa picante que combina entre sus ingredientes: camarones de río, papa amarilla, queso, leche, maíces y un aderezo de ají y huacatay que le da un sabor auténtico. Ideal para personas que disfrutan lo picante y son amantes de los camarones. ")
            put("price", 12.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Chupe-de-camarones-El-Comercio.jpg")
            put("restaurant", 3)
            put("restaurantName", "Pasta Canteen")
            put("qualification", "5.0")
        }
        val valuesF6 = ContentValues().apply {
            put("name", "Adobo arequipeño")
            put("description", "De acuerdo con la tradición arequipeña este es un plato que se come los domingos. Preparado en base a lomo de cerdo con una salsa que combina ají molido, cebolla, chicha de jora y otros condimentos. Este plato se caracteriza por su tierna y jugosa carne y su consistencia espesa, además suele ir acompañado por pan. La definición de este plato es: picante y sabroso")
            put("price", 15.0)
            put("image", "https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg")
            put("restaurant", 3)
            put("restaurantName", "Pasta Canteen")
            put("qualification", "6.0")
        }




        val newRowIdF = db?.insert("food", null, valuesF)
        val newRowIdF2 = db?.insert("food", null, valuesF2)
        val newRowIdF3 = db?.insert("food", null, valuesF3)
        val newRowIdF4 = db?.insert("food", null, valuesF4)
        val newRowIdF5 = db?.insert("food", null, valuesF5)
        val newRowIdF6 = db?.insert("food", null, valuesF6)
        Log.e("Agregado ", newRowIdF6.toString())

        //Ingresar ordenes
        val valuesO = ContentValues().apply {
            put("date", "24/05")
            put("user", "Luis")
            put("total", 25.00)
            put("status", 1)
        }
        val newRowIdO = db?.insert("orders", null, valuesO)

        val valuesO2 = ContentValues().apply {
            put("date", "23/05")
            put("user", "Luis")
            put("total", 20.00)
            put("status", 1)
        }
        val newRowIdO2 = db?.insert("orders", null, valuesO2)

        val valuesO3 = ContentValues().apply {
            put("date", "Hoy")
            put("user", "Luis")
            put("total", 150.00)
            put("status", 0)
        }
        val newRowIdO3 = db?.insert("orders", null, valuesO3)


        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putInt(getString(R.string.preference_file_key), 1)
            apply()
        }
    }
}
