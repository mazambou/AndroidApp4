package com.example.superpodcast.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superpodcast.model.Podcast
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun PodcastDetailScreen(
    podcast: Podcast?,
    isSubscribed: Boolean,
    onSubscribe: (Podcast) -> Unit,
    onUnsubscribe: (Long) -> Unit,
    onBackClick: () -> Unit
) {

    if (podcast == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Button(
                onClick = onBackClick
            ) {
                Text("Back")
            }

            Text(
                text = "Podcast not found.",
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        // Back button
        Button(
            onClick = onBackClick
        ) {
            Text("Back")
        }

        AsyncImage(
            model = podcast.artworkUrl100,
            contentDescription = podcast.collectionName,
            modifier = Modifier
                .padding(top = 20.dp)
                .size(180.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        // Podcast title
        Text(
            text = podcast.collectionName,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Podcast author
        Text(
            text = podcast.artistName,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Podcast genre
        Text(
            text = "Genre: ${podcast.primaryGenreName}",
            modifier = Modifier.padding(top = 16.dp)
        )

        // Podcast country
        Text(
            text = "Country: ${podcast.country}",
            modifier = Modifier.padding(top = 8.dp)
        )

        // Number of episodes
        Text(
            text = "Episodes: ${podcast.trackCount}",
            modifier = Modifier.padding(top = 8.dp)
        )

        // Subscribe / Unsubscribe button
        if (isSubscribed) {

            Button(
                onClick = {
                    onUnsubscribe(podcast.collectionId)
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Unsubscribe")
            }

        } else {

            Button(
                onClick = {
                    onSubscribe(podcast)
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Subscribe")
            }
        }
    }
}