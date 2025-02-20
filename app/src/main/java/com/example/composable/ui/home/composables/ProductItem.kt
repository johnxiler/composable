package com.example.composable.ui.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun ProductList(
    onClick: (String) -> Unit
) {
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
            ingredients = listOf("sibuyas","sibuyas putih","sibuyas merah"),
            steps = listOf("boil egg for 1 hour", "boil egg for 1 hour"),
            duration = 10
        ),
        ProductModel(
            id = 3,
            name = "Product 3",
            price = 20.0,
            imageUrl = R.drawable.food_three,
            ingredients = listOf("toyo","toyo putih","toyo merah"),
            steps = listOf("boil rice for 1 hour", "boil rice for 1 hour"),
            duration = 10
        ),
        ProductModel(
            id = 4,
            name = "Product 4",
            price = 20.0,
            imageUrl = R.drawable.food_four,
            ingredients = listOf("suka","suka putih","suka merah"),
            steps = listOf("boil sugar for 1 hour", "boil sugar for 1 hour"),
            duration = 10
        ),
        ProductModel(
            id = 5,
            name = "Product 5",
            price = 35.0,
            imageUrl = R.drawable.food_five,
            ingredients = listOf("vinegar","vinegar putih","vinegar merah"),
            steps = listOf("boil vinegar for 1 hour", "boil vinegar for 1 hour"),
            duration = 10
        ),
        ProductModel(
            id = 6,
            name = "Product 6",
            price = 20.0,
            imageUrl = R.drawable.food_six,
            ingredients = listOf("tepung","tepung putih","tepung merah"),
            steps = listOf("boil flour for 1 hour", "boil flour for 1 hour"),
            duration = 10
        ),
        ProductModel(
            id = 7,
            name = "Product 7",
            price = 20.0,
            imageUrl = R.drawable.food_seven,
            ingredients = listOf("tepung","tepung putih","tepung merah"),
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
    LazyColumn(contentPadding = PaddingValues(12.dp)) {
        items(products) { product ->
            ProductItem(product = product) {
                onClick(it)
            }
        }
    }
}

@Composable
fun ProductItem(
    product: ProductModel,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .padding(vertical = 1.dp)
            .clickable {
                onClick(product.name)
            }
    ) {
        Row(
            modifier = modifier
                .padding(start = 6.dp, end = 6.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .weight(1F),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = product.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = product.name)
            }
            Text(
                text = product.price.toString(),
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = ProductModel(
            id = 1,
            name = "Product 1",
            price = 10.0,
            imageUrl = R.drawable.food_one,
            ingredients = listOf(),
            steps = listOf(),
            duration = 10
        ),
        onClick = {}
    )
}