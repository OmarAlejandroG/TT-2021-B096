package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast

class Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val back_opc: ImageButton = findViewById(R.id.back_opc)
        back_opc.setOnClickListener{
            startActivity(Intent(this, menu_principal::class.java))
        }

        val ad_opc: Button = findViewById(R.id.ad_opc)
        ad_opc.setOnClickListener{
            Toast.makeText(applicationContext, "In development", Toast.LENGTH_SHORT).show()
        }

        val ac_opc: SeekBar = findViewById(R.id.ac_opc)
        ac_opc.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Nivel de velocidad: " + ac_opc.progress.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        val prox_opc: SeekBar = findViewById(R.id.prox_opc)
        prox_opc.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Proximidad permitida: " + prox_opc.progress.toString() + " Metros", Toast.LENGTH_SHORT).show()
            }

        })

    }
}