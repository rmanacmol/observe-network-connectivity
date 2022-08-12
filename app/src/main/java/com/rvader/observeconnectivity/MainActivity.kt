package com.rvader.observeconnectivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rvader.observeconnectivity.ui.theme.ObserveConnectivityTheme

/**
 * Created by Renz Manacmol 12/08/2022.
 */

class MainActivity : ComponentActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        setContent {
            ObserveConnectivityTheme {

                val status by connectivityObserver.observe().collectAsState(
                    initial = ConnectivityObserver.Status.Unavailable
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Staus(status.toString())
                }
            }
        }
    }
}

@Composable
fun Staus(status: String) {
    Text(text = "Network Status $status!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ObserveConnectivityTheme {
        Staus("Android")
    }
}