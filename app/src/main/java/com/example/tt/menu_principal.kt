package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.ingenieriajhr.blujhr.BluJhr

class menu_principal : AppCompatActivity() {

    var addres = ""

    lateinit var blu: BluJhr

    var estadoConexion = BluJhr.Connected.False

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        addres = intent.getStringExtra("addres").toString()

        blu = BluJhr(this)

        blu.setDataLoadFinishedListener(object:BluJhr.ConnectedBluetooth{
            override fun onConnectState(state: BluJhr.Connected) {
                when (state) {
                    BluJhr.Connected.True -> {
                        Toast.makeText(applicationContext, "Conexión establecida", Toast.LENGTH_SHORT).show()
                        estadoConexion = state
                        rxReceived()
                    }
                    BluJhr.Connected.Pending -> {
                        Toast.makeText(applicationContext, "Conexión pendiente", Toast.LENGTH_SHORT).show()
                        estadoConexion = state

                    }
                    BluJhr.Connected.False -> {
                        Toast.makeText(applicationContext, "Conexión fallida", Toast.LENGTH_SHORT).show()
                        estadoConexion = state
                        blu.closeConnection()
                        true
                        startActivity(Intent(applicationContext, Enlace::class.java))
                    }
                    BluJhr.Connected.Disconnect -> {
                        Toast.makeText(applicationContext, "Desconectar", Toast.LENGTH_SHORT).show()
                        estadoConexion = state
                        startActivity(Intent(applicationContext,MainActivity::class.java))
                    }
                }
            }
        })

        /*btnSend.setOnClickListener {
            blu.bluTx(edtSend.text.toString())
        }*/

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

        /*val btn_cm: Button = findViewById(R.id.btn_cm)
        btn_cm.setOnClickListener{
            startActivity(Intent(this, control_manual::class.java))
        }

        val btn_opc: Button = findViewById(R.id.btn_opc)
        btn_opc.setOnClickListener{
            startActivity(Intent(this, Opciones::class.java))
        }*/

        val btn_back: ImageButton = findViewById(R.id.btn_back)
        btn_back.setOnClickListener{
            blu.closeConnection()
            true
            startActivity(Intent(this, Enlace::class.java))
        }

        if (estadoConexion != BluJhr.Connected.True){
            blu.connect(addres)
        }

    }

    private fun rxReceived() {
        blu.loadDateRx(object:BluJhr.ReceivedData{
            override fun rxDate(rx: String) {
                //txtConsola.text = txtConsola.text.toString() +rx
                Toast.makeText(this@menu_principal, "Recibido", Toast.LENGTH_SHORT).show()
            }
        })
    }

}