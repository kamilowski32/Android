package com.example.zadanie5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val cart = Cart.getCart()
        val totalPrice = cart.products.map { it.price }.sum()

        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)
        tvTotalPrice.text = "Total price: $totalPrice"

        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        btnConfirm.setOnClickListener {
            //cart.clear()
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }

}
