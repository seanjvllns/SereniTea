package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeicedmatchaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homeicedmatcha)

        // Ensure the correct root view is used for edge-to-edge display
        val rootView = findViewById<View>(R.id.main) // Ensure this matches your root layout ID
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigation back to HomeActivity
        findViewById<TextView>(R.id.backhome_icedmatcha).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Removes the activity from the back stack
        }

        // Quantity adjustment logic
        val quantityTextView: TextView = findViewById(R.id.textView86)
        val increaseButton: TextView = findViewById(R.id.addhomemocha)
        val decreaseButton: TextView = findViewById(R.id.homemmochaminus) 

        var quantity = 1 // Default quantity

        // Increase quantity
        increaseButton.setOnClickListener {
            quantity++
            quantityTextView.text = quantity.toString()
        }

        // Decrease quantity but not below 1
        decreaseButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityTextView.text = quantity.toString()
            }
        }
    }
}
