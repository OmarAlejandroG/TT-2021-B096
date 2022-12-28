package com.example.tt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.ingenieriajhr.blujhr.BluJhr
import kotlinx.android.synthetic.main.activity_enlace.*
import kotlinx.android.synthetic.main.activity_menu_principal.*

class menu_principal : AppCompatActivity() {

    var addres = ""

    lateinit var blu: BluJhr
    var devicesBluetooth = ArrayList<String>()

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

        val btn_back: ImageButton = findViewById(R.id.btn_back)
        val ad_mp: Button = findViewById(R.id.ad_mp)
        val btn_vel: Button = findViewById(R.id.btn_vel)
        val btn_batt: Button = findViewById(R.id.btn_batt)
        val btn_cm: Button = findViewById(R.id.btn_cm)
        val btn_opc: Button = findViewById(R.id.btn_opc)


        ad_mp.setOnClickListener{
            Toast.makeText(applicationContext, "In development", Toast.LENGTH_SHORT).show()
        }

        btn_vel.setOnClickListener{
            //Toast.makeText(applicationContext, btn_vel.text, Toast.LENGTH_SHORT).show()
            blu.bluTx(10.toString())
        }

        btn_batt.setOnClickListener{
            //Toast.makeText(applicationContext, btn_batt.text, Toast.LENGTH_SHORT).show()
            blu.bluTx("20")
        }

        btn_cm.setOnClickListener{
            btn_back.visibility = View.GONE
            textView5.visibility = View.GONE
            ad_mp.visibility = View.GONE
            btn_vel.visibility = View.GONE
            btn_batt.visibility = View.GONE
            btn_cm.visibility = View.GONE
            btn_opc.visibility = View.GONE

            btn_up2.visibility = View.VISIBLE
            btn_left2.visibility = View.VISIBLE
            sb_ac2.visibility = View.VISIBLE
            sb_prox2.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            btn_sp2.visibility = View.VISIBLE
            btn_right2.visibility = View.VISIBLE
            textView13.visibility = View.VISIBLE
            btn_down2.visibility = View.VISIBLE
            btn_exit.visibility = View.VISIBLE
        }

        btn_opc.setOnClickListener{
            btn_back.visibility = View.GONE
            textView5.visibility = View.GONE
            ad_mp.visibility = View.GONE
            btn_vel.visibility = View.GONE
            btn_batt.visibility = View.GONE
            btn_cm.visibility = View.GONE
            btn_opc.visibility = View.GONE

            sb_ac2.visibility = View.VISIBLE
            sb_prox2.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView13.visibility = View.VISIBLE
            btn_exit.visibility = View.VISIBLE
        }

        btn_exit.setOnClickListener{
            btn_up2.visibility = View.GONE
            btn_left2.visibility = View.GONE
            sb_ac2.visibility = View.GONE
            sb_prox2.visibility = View.GONE
            textView10.visibility = View.GONE
            btn_sp2.visibility = View.GONE
            btn_right2.visibility = View.GONE
            textView13.visibility = View.GONE
            btn_down2.visibility = View.GONE
            btn_exit.visibility = View.GONE

            btn_back.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            ad_mp.visibility = View.VISIBLE
            btn_vel.visibility = View.VISIBLE
            btn_batt.visibility = View.VISIBLE
            btn_cm.visibility = View.VISIBLE
            btn_opc.visibility = View.VISIBLE
        }

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
                //Toast.makeText(this@menu_principal, "Recibido", Toast.LENGTH_SHORT).show()

            }
        })
    }

}