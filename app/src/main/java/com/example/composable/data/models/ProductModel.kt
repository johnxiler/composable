package com.example.composable.data.models

data class ProductModel(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: Int,
    val ingredients: List<String>,
    val steps: List<String>,
    val duration: Int
)

