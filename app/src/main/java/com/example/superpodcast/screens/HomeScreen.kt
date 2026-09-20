package com.example.superpodcast.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onSearchClick: () -> Unit,
    onSubscriptionsClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "SuperPodcast",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Discover your next favourite podcast.",
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 32.dp
            )
        )

        Button(
            onClick = onSearchClick
        ) {

            Text("Search Podcasts")
        }

        Button(
            onClick = onSubscriptionsClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {

            Text("My Subscriptions")
        }
    }
}