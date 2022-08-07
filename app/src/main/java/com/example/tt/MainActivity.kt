package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_enlazar: Button = findViewById(R.id.btn_enlazar)
        btn_enlazar.setOnClickListener{
            startActivity(Intent(this, Enlace::class.java))
        }

        val btn_ad: Button = findViewById(R.id.btn_ad)
        btn_ad.setOnClickListener{
            Toast.makeText(applicationContext, "In development", Toast.LENGTH_SHORT).show()
        }

    }
}