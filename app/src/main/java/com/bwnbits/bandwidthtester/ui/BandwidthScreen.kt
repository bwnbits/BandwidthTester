package com.bwnbits.bandwidthtester.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bwnbits.bandwidthtester.model.DownloadStats



@Composable
fun BandwidthScreen(

    stats: DownloadStats,

    onStart: () -> Unit,

    onStop: () -> Unit

) {


    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .padding(24.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center

    ) {



        Text(

            text = "Bandwidth Tester",

            style =
                MaterialTheme.typography
                    .headlineMedium

        )



        Spacer(
            Modifier.height(40.dp)
        )



        Text(

            text =
                String.format(
                    "%.2f Mbps",
                    stats.currentSpeedMbps
                ),

            style =
                MaterialTheme.typography
                    .displayLarge

        )



        Spacer(
            Modifier.height(20.dp)
        )



        Text(
            text =
                "Downloaded: ${
                    stats.totalBytesDownloaded /
                    1024 /
                    1024
                } MB"
        )



        Text(
            text =
                "Time: ${stats.elapsedSeconds}s"
        )



        Text(
            text =
                stats.status
        )



        Spacer(
            Modifier.height(30.dp)
        )



        LinearProgressIndicator(

            modifier =
                Modifier.fillMaxWidth(),

            progress =
                if(stats.isRunning)
                    1f
                else
                    0f

        )



        Spacer(
            Modifier.height(30.dp)
        )



        Row {


            Button(

                onClick = onStart

            ) {

                Text("START")

            }



            Spacer(
                Modifier.width(20.dp)
            )



            Button(

                onClick = onStop

            ) {

                Text("STOP")

            }


        }


    }

}
