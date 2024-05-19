package com.example.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text

import com.example.myapplication.android.ui.MainView

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // setComponent is an extension method of ComponentActivity.
        // The last parameter is the UI - you pass in a function that returns a @Composable.
        setContent {

            // Call our @Composable MainView() function, to build the main view with a suitable "top bar".
            MainView {
                TopAppBar(title = {
                    if (it == 0)
                        Text("World clocks")
                    else
                        Text("Find meeting")
                })
            }
        }
    }
}
