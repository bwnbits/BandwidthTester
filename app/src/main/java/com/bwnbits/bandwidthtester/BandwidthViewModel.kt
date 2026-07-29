package com.bwnbits.bandwidthtester

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bwnbits.bandwidthtester.model.DownloadStats
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class BandwidthViewModel : ViewModel() {


    private val downloader =
        Downloader()


    private val _stats =
        MutableStateFlow(
            DownloadStats()
        )


    val stats =
        _stats.asStateFlow()


    private var downloadJob: Job? = null


    private var timerJob: Job? = null


    private var totalBytes = 0L


    private var startTime = 0L



    fun start() {


        if (downloadJob != null)
            return


        totalBytes = 0L

        startTime =
            System.currentTimeMillis()



        _stats.value =
            DownloadStats(
                isRunning = true,
                status = "Running"
            )


        timerJob =
            viewModelScope.launch {

                while (true) {

                    updateStats()

                    delay(1000)

                }

            }



        downloadJob =
            viewModelScope.launch {


                downloader.startDownload { bytes ->


                    totalBytes += bytes


                }


            }


    }



    private fun updateStats() {


        val elapsed =
            (
                System.currentTimeMillis()
                -
                startTime
            ) / 1000



        val speed =
            if (elapsed > 0) {

                totalBytes *
                        8.0 /
                        elapsed /
                        1_000_000

            } else {

                0.0

            }



        _stats.value =
            DownloadStats(

                currentSpeedMbps =
                    speed,

                averageSpeedMbps =
                    speed,

                totalBytesDownloaded =
                    totalBytes,

                elapsedSeconds =
                    elapsed,

                isRunning = true,

                status = "Running"

            )


    }



    fun stop() {


        downloadJob?.cancel()

        timerJob?.cancel()


        downloadJob = null

        timerJob = null



        _stats.value =
            DownloadStats(

                totalBytesDownloaded =
                    totalBytes,

                isRunning = false,

                status = "Stopped"

            )


    }



    override fun onCleared() {

        stop()

        super.onCleared()

    }


}
