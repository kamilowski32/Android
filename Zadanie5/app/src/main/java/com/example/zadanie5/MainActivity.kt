package com.example.zadanie5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val products = arrayListOf<Product>()
    private val productAdapter = ProductAdapter(products) { product ->
        val productIntent = Intent(this, ProductActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("product", product)
        productIntent.putExtras(bundle)
        startActivity(productIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        products.addAll(Product.getProductList())
        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        rvProducts.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvProducts.adapter = productAdapter

        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        val btnViewCart = findViewById<Button>(R.id.btnViewCart)
        btnAddToCart.setOnClickListener {
            val selectedProducts = products.filter { it.selected }
            if (selectedProducts.isEmpty()) {
                Toast.makeText(this, "Please select a product to add to the cart", Toast.LENGTH_SHORT).show()
            } else {
                selectedProducts.forEach { product ->
                    Cart.addProduct(product)
                    product.selected = false
                }
                productAdapter.notifyDataSetChanged()
            }
        }

        btnViewCart.setOnClickListener {
            val cartIntent = Intent(this, CartActivity::class.java)
            startActivity(cartIntent)
        }
    }
}
