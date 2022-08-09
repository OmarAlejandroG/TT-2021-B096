package com.example.tt

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_enlace.*
import com.ingenieriajhr.blujhr.BluJhr

class Enlace : AppCompatActivity() {

    lateinit var blue: BluJhr
    var devicesBluetooth = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlace)

        blue = BluJhr(this)
        blue.onBluetooth()

        bt_list.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "Conexión", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, menu_principal::class.java)
            intent.putExtra("addres", devicesBluetooth[i])
            startActivity(intent)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (blue.checkPermissions(requestCode,grantResults)){
            Toast.makeText(this, "Encendido de BlueTooth", Toast.LENGTH_SHORT).show()
            blue.initializeBluetooth()
        }else{
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
                blue.initializeBluetooth()
            }else{
                Toast.makeText(this, "Algo salió mal", Toast.LENGTH_SHORT).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!blue.stateBluetoooth() && requestCode == 100){
            blue.initializeBluetooth()
        }else{
            if (requestCode == 100){
                devicesBluetooth = blue.deviceBluetooth()
                if (devicesBluetooth.isNotEmpty()){
                    val adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,devicesBluetooth)
                    bt_list.adapter = adapter
                }else{
                    Toast.makeText(this, "No tienes dispositivos vinculados", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlace)

        /*val ref: ImageButton = findViewById(R.id.ref)
        ref.setOnClickListener{
            startActivity(Intent(this, menu_principal::class.java))
        }

        val bt_list : ListView = findViewById(R.id.bt_list)*/



    }*/