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
    products: List<ProductModel>,
    onClick: (Int) -> Unit
) {
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
    onClick: (Int) -> Unit
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
                onClick(product.id)
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