package com.example.composable.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composable.R
import com.example.composable.common.theme.ComposableTheme
import com.example.composable.data.models.ProductModel
import com.example.composable.ui.home.HomeScreen
import com.example.composable.ui.productdetailscreen.ProductDetailsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposableTheme {
                val products = listOf(
                    ProductModel(
                        id = 1,
                        name = "Product 1",
                        price = 10.0,
                        imageUrl = R.drawable.food_one,
                        ingredients = listOf("bawang", "bawang putih", "bawang merah"),
                        steps = listOf("boil water for 1 minute", "boil water for 1 minute"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 2,
                        name = "Product 2",
                        price = 20.0,
                        imageUrl = R.drawable.food_two,
                        ingredients = listOf("sibuyas", "sibuyas putih", "sibuyas merah"),
                        steps = listOf("boil egg for 1 hour", "boil egg for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 3,
                        name = "Product 3",
                        price = 20.0,
                        imageUrl = R.drawable.food_three,
                        ingredients = listOf("toyo", "toyo putih", "toyo merah"),
                        steps = listOf("boil rice for 1 hour", "boil rice for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 4,
                        name = "Product 4",
                        price = 20.0,
                        imageUrl = R.drawable.food_four,
                        ingredients = listOf("suka", "suka putih", "suka merah"),
                        steps = listOf("boil sugar for 1 hour", "boil sugar for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 5,
                        name = "Product 5",
                        price = 35.0,
                        imageUrl = R.drawable.food_five,
                        ingredients = listOf("vinegar", "vinegar putih", "vinegar merah"),
                        steps = listOf("boil vinegar for 1 hour", "boil vinegar for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 6,
                        name = "Product 6",
                        price = 20.0,
                        imageUrl = R.drawable.food_six,
                        ingredients = listOf("tepung", "tepung putih", "tepung merah"),
                        steps = listOf("boil flour for 1 hour", "boil flour for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 7,
                        name = "Product 7",
                        price = 20.0,
                        imageUrl = R.drawable.food_seven,
                        ingredients = listOf("tepung", "tepung putih", "tepung merah"),
                        steps = listOf("boil flour for 1 hour", "boil flour for 1 hour"),
                        duration = 10
                    ),
                    ProductModel(
                        id = 8,
                        name = "Product 8",
                        price = 20.0,
                        imageUrl = R.drawable.food_eight,
                        ingredients = listOf(),
                        steps = listOf(),
                        duration = 10
                    )
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screens.Home.route) {
                            HomeScreen(
                                products = products,
                                modifier = Modifier.padding(innerPadding),
                            ) {
                                navController.navigate(route = Screens.Details.route + "/$it")
                            }
                        }
                        composable(Screens.Details.route + "/{id}") {
                            val id = it.arguments?.getString("id")
                            val product = products.find { prod ->
                                prod.id == id?.toInt()
                            }
                            product?.let { prod ->
                                ProductDetailsScreen(
                                    product = prod

                                )
                            }

                        }
                    }
                }
            }
        }
    }

    sealed class Screens(val route: String) {
        data object Home : Screens("home_screen")
        data object Details : Screens("details_screen")
    }
}
