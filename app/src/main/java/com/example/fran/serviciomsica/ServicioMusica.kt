package com.example.fran.serviciomsica

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import android.media.MediaPlayer
/**
 * Created by Fran on 16/01/2018.
 */
class ServicioMusica : Service() {

    var reproductor: MediaPlayer? = null

    override fun onCreate() {
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show()
        reproductor = MediaPlayer.create(this, R.raw.audio)
    }

    /*
    override fun onStartCommand(intent: Intent, flags: Int, idArranque: Int): Int {
        Toast.makeText(this, "Servicio arrancado " + idArranque, Toast.LENGTH_SHORT).show()
        reproductor!!.start()
        return START_STICKY
    }
    */

    public override fun onStart(intent: Intent, startId: Int) {
        Toast.makeText(this, "Servicio arrancado " + startId, Toast.LENGTH_SHORT).show()
        reproductor!!.start()
    }

    override fun onDestroy() {
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show()
        reproductor!!.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        return null
    }
}
