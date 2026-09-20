package com.example.superpodcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.superpodcast.navigation.AppNavigation
import com.example.superpodcast.ui.theme.SuperPodcastTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContent {

            SuperPodcastTheme {

                AppNavigation()
            }
        }
    }
}