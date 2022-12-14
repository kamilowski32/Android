package com.example.zadanie5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private val products = arrayListOf<Product>()
    private val productAdapter = ProductAdapter(products) { product ->
        Cart.removeProduct(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        products.addAll(Cart.getCart().products)
        val rvCart = findViewById<RecyclerView>(R.id.rvCart)
        rvCart.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvCart.adapter = productAdapter

        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener {
            val checkoutIntent = Intent(this, CheckoutActivity::class.java)
            startActivity(checkoutIntent)
        }
    }
}
