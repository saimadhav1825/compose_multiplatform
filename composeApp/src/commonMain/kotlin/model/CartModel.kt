package model

import androidx.compose.ui.graphics.Color

data class CartModel(
    val image: String,
    val name: String,
    val description: String,
    val size: Int,
    val color: Color,
    val price: Int
)