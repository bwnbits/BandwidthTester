package com.bwnbits.bandwidthtester

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import kotlin.coroutines.coroutineContext


class Downloader {


    private val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .build()


    private val testUrl =
        "https://speedtest.tele2.net/100MB.zip"



    suspend fun startDownload(
        onBytesRead: (Long) -> Unit
    ) = withContext(Dispatchers.IO) {


        while (coroutineContext.isActive) {


            try {


                val request = Request.Builder()
                    .url(testUrl)
                    .build()


                client.newCall(request).execute().use { response ->


                    if (!response.isSuccessful) {
                        return@use
                    }


                    val body = response.body ?: return@use


                    body.byteStream().use { input ->


                        val buffer = ByteArray(16384)


                        while (
                            coroutineContext.isActive
                        ) {


                            val bytes =
                                input.read(buffer)


                            if (bytes == -1) {
                                break
                            }


                            onBytesRead(bytes.toLong())

                        }

                    }

                }


            } catch (
                e: IOException
            ) {


                kotlinx.coroutines.delay(2000)


            }

        }

    }


}
