package com.example.fran.serviciomsica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrancar = findViewById<View>(R.id.boton_arrancar) as Button
        arrancar.setOnClickListener(this)

        val detener = findViewById<View>(R.id.boton_detener) as Button
        detener.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, ServicioMusica::class.java)
        when (v.getId()) {
            R.id.boton_arrancar -> startService(intent)
            R.id.boton_detener -> stopService(intent)
        }
    }

}
