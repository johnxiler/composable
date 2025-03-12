package com.example.composable.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composable.data.models.ProductModel
import com.example.composable.ui.home.composables.ProductList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    products: List<ProductModel>,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Recipe Book",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .padding(top = 25.dp, bottom = 25.dp, start = 24.dp)
        )
        ProductList(products) {
            onItemClick(it)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        products = emptyList(),
        onItemClick = {}
    )
}