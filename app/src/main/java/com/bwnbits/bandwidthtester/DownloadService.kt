package com.bwnbits.bandwidthtester


import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.*



class DownloadService : Service() {


    private val scope =
        CoroutineScope(
            Dispatchers.IO +
            SupervisorJob()
        )


    private var downloaderJob:
            Job? = null



    override fun onCreate() {

        super.onCreate()

        NotificationHelper.createChannel(this)

    }



    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {


        val notification =
            NotificationCompat.Builder(
                this,
                NotificationHelper.CHANNEL_ID
            )
                .setContentTitle(
                    "Bandwidth Tester"
                )
                .setContentText(
                    "Running..."
                )
                .setSmallIcon(
                    android.R.drawable.stat_sys_download
                )
                .build()



        startForeground(
            1,
            notification
        )


        downloaderJob =
            scope.launch {


                Downloader()
                    .startDownload {


                    }

            }


        return START_STICKY

    }



    override fun onDestroy() {


        downloaderJob?.cancel()


        scope.cancel()


        super.onDestroy()

    }



    override fun onBind(
        intent: Intent?
    ): IBinder? = null


}
