package com.example.zadanie5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val bundle = intent.getExtras()
        val product= bundle?.getSerializable("product") as Product
        var nameField = findViewById<TextView>(R.id.tvProductName)
        var productDescription = findViewById<TextView>(R.id.tvProductDescription)
        var productPrice = findViewById<TextView>(R.id.tvProductPrice)
        var btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        nameField.text = product.name
        productDescription.text = product.description
        productPrice.text = product.price.toString()

        btnAddToCart.setOnClickListener {
            Cart.addProduct(product)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
