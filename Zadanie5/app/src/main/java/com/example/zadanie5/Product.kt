package com.example.zadanie5

import java.io.Serializable

data class Product(
    var name: String,
    var price: Double,
    var description: String,
    var selected: Boolean = false
) : Serializable {
    companion object {
        fun getProductList(): List<Product> {
            // Return a list of Product objects
            return listOf(
                Product("Product 1", 100.0, "Description for product 1"),
                Product("Product 2", 200.0, "Description for product 2"),
                Product("Product 3", 300.0, "Description for product 3")
            )
        }
    }
}

