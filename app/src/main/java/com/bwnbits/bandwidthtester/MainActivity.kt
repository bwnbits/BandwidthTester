package com.bwnbits.bandwidthtester


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.bwnbits.bandwidthtester.ui.BandwidthScreen
import com.bwnbits.bandwidthtester.ui.theme.BandwidthTheme



class MainActivity : ComponentActivity() {


    private val viewModel:
            BandwidthViewModel by viewModels()



    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)



        setContent {


            BandwidthTheme {


                val stats by
                viewModel.stats
                    .collectAsState()



                BandwidthScreen(

                    stats = stats,

                    onStart = {

                        viewModel.start()

                    },

                    onStop = {

                        viewModel.stop()

                    }

                )


            }


        }


    }


}
