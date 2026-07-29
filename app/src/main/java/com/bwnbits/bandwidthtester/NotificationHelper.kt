package com.bwnbits.bandwidthtester


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build



object NotificationHelper {


    const val CHANNEL_ID =
        "bandwidth_channel"



    fun createChannel(
        context: Context
    ) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel =
                NotificationChannel(
                    CHANNEL_ID,
                    "Bandwidth Test",
                    NotificationManager.IMPORTANCE_LOW
                )


            val manager =
                context.getSystemService(
                    NotificationManager::class.java
                )


            manager.createNotificationChannel(channel)

        }

    }


}
