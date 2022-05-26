import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dev0.deliveryfood.R
import com.dev0.deliveryfood.feature_food.presentation.food_detail.FoodDetailState
import com.dev0.deliveryfood.feature_food.presentation.food_detail.FoodDetailViewModel
import com.dev0.deliveryfood.feature_food.presentation.food_detail.components.FoodCardDetail

@Composable
fun FoodDetailScreen(
    navController: NavHostController,
    foodId: Int?,
    viewModel: FoodDetailViewModel = FoodDetailViewModel()
) {

    if (foodId != null) viewModel.getFoodById(id = foodId)
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        FoodCardDetail(state){ cant ->
            viewModel.addToOrder(cant)
        }
    }
}
