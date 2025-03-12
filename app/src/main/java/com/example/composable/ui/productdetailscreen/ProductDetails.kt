package com.example.composable.ui.productdetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composable.R
import com.example.composable.data.models.ProductModel

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    product: ProductModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

        ) {
        Text(
            text = "Recipe Book",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .padding(30.dp)
        )
        Column(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(text = product.name)
            Card(
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.2F),
                shape = MaterialTheme.shapes.medium,
                elevation = CardDefaults.elevatedCardElevation(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Image(
                        painter = painterResource(id = product.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        alignment = Alignment.Center,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth()

            ) {
                Text(text = "Duration", color = Color.Blue)
                Text(
                    text = product.duration.toString(),
                    modifier = Modifier.padding(5.dp)
                )
                Text(text = "Ingredients", color = Color.Blue)
                product.ingredients.forEach {
                    Text(text = it, modifier = Modifier.padding(5.dp))
                }
                Text(text = "Steps", color = Color.Blue)
                product.steps.forEach {
                    Text(text = it, modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        product = ProductModel(
            imageUrl = R.drawable.food_one,
            name = "Product 1",
            price = 10.0,
            id = 1,
            ingredients = listOf("bawang", "bawang putih", "bawang merah"),
            steps = listOf("boil water for 1 minute", "boil water for 1 minute"),
            duration = 10
        )
    )
}