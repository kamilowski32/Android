package com.example.zadanie5

data class Cart(var products: List<Product>) : java.io.Serializable {
    companion object {
        private var cart = Cart(emptyList())
        fun addProduct(product: Product) {
            cart.products += product
        }
        fun removeProduct(product: Product)
        {
            cart.products -= product
        }
        fun getCart(): Cart {
            return cart
        }
        fun clear()
        {

        }
    }
}