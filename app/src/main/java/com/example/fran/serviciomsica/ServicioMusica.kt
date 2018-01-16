package com.example.fran.serviciomsica

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import android.media.MediaPlayer
import android.app.NotificationManager
import android.app.PendingIntent
/**
 * Created by Fran on 16/01/2018.
 */
class ServicioMusica : Service() {

    var reproductor: MediaPlayer? = null
    private var notificationManager: NotificationManager? = null
    private val ID_NOTIFICACION = 1

    override fun onCreate() {
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show()
        reproductor = MediaPlayer.create(this, R.raw.audio)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun onStartCommand(intent: Intent, flags: Int, idArranque: Int): Int {
        Toast.makeText(this, "Servicio arrancado " + idArranque, Toast.LENGTH_SHORT).show()
        reproductor!!.start()
        //return START_STICKY
        val intent = Intent(this, MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val vibrate = longArrayOf(0, 100, 200, 300)

        val notification = Notification.Builder(this).setContentTitle("Reproduciendo música")
                .setContentText("Información adicional")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setVibrate(vibrate)
                .setLights(-0xff01, 0, 0)
                .getNotification()
        notification.flags = notification.flags or Notification.FLAG_SHOW_LIGHTS

        notificationManager!!.notify(ID_NOTIFICACION, notification)

        return START_STICKY
    }

    /*
    public override fun onStart(intent: Intent, startId: Int) {
        Toast.makeText(this, "Servicio arrancado " + startId, Toast.LENGTH_SHORT).show()
        reproductor!!.start()
    }
    */

    override fun onDestroy() {
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show()
        reproductor!!.stop()

        notificationManager!!.cancel(ID_NOTIFICACION);
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        return null
    }
}
