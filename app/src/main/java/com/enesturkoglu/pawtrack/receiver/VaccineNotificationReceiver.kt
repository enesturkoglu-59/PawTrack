package com.enesturkoglu.pawtrack.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.enesturkoglu.pawtrack.R

class VaccineNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val name = intent.getStringExtra("vaccine_name") ?: "Aşı"
        val date = intent.getStringExtra("vaccine_date") ?: ""

        val builder = NotificationCompat.Builder(context, "vaccine_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground) // kendi ikonunu koyabilirsin
            .setContentTitle("Aşı Hatırlatması")
            .setContentText("$name - $date tarihinde yapılmalı")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = NotificationManagerCompat.from(context)
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            notificationManager.notify(name.hashCode(), builder.build())
        } else {
            Log.w("Notification", "Bildirim izni yok, gönderilmedi.")
        }
    }
}