package com.enesturkoglu.pawtrack.calendar.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.enesturkoglu.pawtrack.receiver.VaccineNotificationReceiver
import com.enesturkoglu.pawtrack.data.model.VaccineEntity


fun scheduleNotification(context: Context, vaccine: VaccineEntity) {
    val intent = Intent(context, VaccineNotificationReceiver::class.java).apply {
        putExtra("vaccine_name", vaccine.name)
        putExtra("vaccine_date", vaccine.date)
    }

    val pendingIntent = PendingIntent.getBroadcast(
        context,
        vaccine.id,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.setExactAndAllowWhileIdle(
        AlarmManager.RTC_WAKEUP,
        vaccine.timestamp,
        pendingIntent
    )
}
