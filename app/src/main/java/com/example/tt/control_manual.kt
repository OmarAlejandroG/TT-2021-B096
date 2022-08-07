package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast

class control_manual : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_manual)

        val back_cm: ImageButton = findViewById(R.id.back_cm)
        back_cm.setOnClickListener{
            startActivity(Intent(this, menu_principal::class.java))
        }

        val ad_cm: Button = findViewById(R.id.ad_cm)
        ad_cm.setOnClickListener{
            Toast.makeText(applicationContext, "In development", Toast.LENGTH_SHORT).show()
        }

        val sb_ac: SeekBar = findViewById(R.id.sb_ac)
        sb_ac.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Nivel de velocidad: " + sb_ac.progress.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        val sb_prox: SeekBar = findViewById(R.id.sb_prox)
        sb_prox.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Proximidad permitida: " + sb_prox.progress.toString() + " Metros", Toast.LENGTH_SHORT).show()
            }

        })

        val btn_up: ImageButton = findViewById(R.id.btn_up)
        btn_up.setOnClickListener{
            Toast.makeText(applicationContext, "Acelerar", Toast.LENGTH_SHORT).show()
        }

        val btn_down: ImageButton = findViewById(R.id.btn_down)
        btn_down.setOnClickListener{
            Toast.makeText(applicationContext, "Reversa", Toast.LENGTH_SHORT).show()
        }

        val btn_left: ImageButton = findViewById(R.id.btn_left)
        btn_left.setOnClickListener{
            Toast.makeText(applicationContext, "Izquierda", Toast.LENGTH_SHORT).show()
        }

        val btn_right: ImageButton = findViewById(R.id.btn_right)
        btn_right.setOnClickListener{
            Toast.makeText(applicationContext, "Derecha", Toast.LENGTH_SHORT).show()
        }

        val btn_sp: ImageButton = findViewById(R.id.btn_sp)
        btn_sp.setOnClickListener{
            Toast.makeText(applicationContext, "Honk Honk", Toast.LENGTH_SHORT).show()
        }

    }
}