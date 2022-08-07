package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Enlace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlace)

        val ref: ImageButton = findViewById(R.id.ref)
        ref.setOnClickListener{
            startActivity(Intent(this, menu_principal::class.java))
        }

    }
}