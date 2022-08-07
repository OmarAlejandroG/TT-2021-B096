package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class menu_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btn_back: ImageButton = findViewById(R.id.btn_back)
        btn_back.setOnClickListener{
            startActivity(Intent(this, Enlace::class.java))
        }

        val ad_mp: Button = findViewById(R.id.ad_mp)
        ad_mp.setOnClickListener{
            Toast.makeText(applicationContext, "In development", Toast.LENGTH_SHORT).show()
        }

        val btn_vel: Button = findViewById(R.id.btn_vel)
        btn_vel.setOnClickListener{
            Toast.makeText(applicationContext, btn_vel.text, Toast.LENGTH_SHORT).show()
        }

        val btn_batt: Button = findViewById(R.id.btn_batt)
        btn_batt.setOnClickListener{
            Toast.makeText(applicationContext, btn_batt.text, Toast.LENGTH_SHORT).show()
        }

        val btn_cm: Button = findViewById(R.id.btn_cm)
        btn_cm.setOnClickListener{
            startActivity(Intent(this, control_manual::class.java))
        }

        val btn_opc: Button = findViewById(R.id.btn_opc)
        btn_opc.setOnClickListener{
            startActivity(Intent(this, Opciones::class.java))
        }

    }
}