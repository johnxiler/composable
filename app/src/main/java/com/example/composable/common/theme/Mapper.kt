package com.example.composable.common.theme

import com.example.composable.data.models.ProductModel
import com.example.composable.domain.model.RefinedProductModel

fun ProductModel.toRefinedProductModel() = RefinedProductModel(
    imgUrl = imageUrl,
    name = name,
    price = price
)