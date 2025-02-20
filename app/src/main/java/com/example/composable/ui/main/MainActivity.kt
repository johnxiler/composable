package com.example.composable.ui.main

import android.os.Bundle
import android.widget.Toast.*
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screens.Home.route) {
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                makeToast(it)
                            }
                        }
                        composable(Screens.Details.route) {
                            ProductDetailsScreen(
                                product = ProductModel(
                                    id = 1,
                                    name = "Product 1",
                                    price = 10.0,
                                    imageUrl = R.drawable.food_one,
                                    ingredients = listOf(),
                                    steps = listOf(),
                                    duration = 10
                                )
                            )
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

    private fun makeToast(message: String) {
        makeText(this, message, LENGTH_SHORT).show()
    }
}
