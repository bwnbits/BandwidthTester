package com.bwnbits.bandwidthtester.model


data class DownloadStats(

    val currentSpeedMbps: Double = 0.0,

    val averageSpeedMbps: Double = 0.0,

    val totalBytesDownloaded: Long = 0L,

    val elapsedSeconds: Long = 0L,

    val remainingSeconds: Long? = null,

    val isRunning: Boolean = false,

    val status: String = "Stopped"

)
