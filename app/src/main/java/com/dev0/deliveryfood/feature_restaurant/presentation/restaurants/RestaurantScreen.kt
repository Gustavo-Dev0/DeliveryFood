package com.dev0.deliveryfood.feature_restaurant.presentation.restaurants

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.feature_restaurant.presentation.restaurants.components.ItemRestaurant


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantScreen(
    navController: NavHostController,
    navToFoods: (String) -> Unit,
    viewModel: RestaurantsViewModel = RestaurantsViewModel()
) {
    val list = listOf("Zig Zag", "Dimas", "Casta Fior", "Tanta")
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TextField(
            value = "Buscar restaurantes",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Filled.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {

            },
            singleLine = true,
            shape = RectangleShape,
            //colors = TextFieldDefaults.textFieldColors()
        )
        /*Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Restaurantes",
            style = TextStyle(color = Color.Black, fontSize = 36.sp, fontWeight = FontWeight.Black)
        )*/
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        LazyColumn(
            contentPadding = PaddingValues(
                top = 12.dp,
                bottom = 100.dp
            ),

        ) {

            items(state.restaurants.size) { index ->
                ItemRestaurant(item = state.restaurants[index]){
                    navToFoods(state.restaurants[index].id.toString())
                }
            }
        }

    }
}
