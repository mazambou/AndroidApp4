package com.example.superpodcast.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superpodcast.model.Podcast
import com.example.superpodcast.viewmodel.PodcastViewModel
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun SearchScreen(
    viewModel: PodcastViewModel,
    onPodcastClick: (Podcast) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Search Podcasts",
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                label = {
                    Text("Podcast name")
                },
                modifier = Modifier.weight(1f),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(
                onClick = {
                    viewModel.searchPodcasts(searchText)
                }
            ) {

                Text("Search")
            }
        }

        if (viewModel.isLoading) {

            CircularProgressIndicator(
                modifier = Modifier.padding(24.dp)
            )
        }

        viewModel.errorMessage?.let { error ->

            Text(
                text = error,
                modifier = Modifier.padding(16.dp)
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {

            items(viewModel.podcasts) { podcast ->

                PodcastSearchItem(
                    podcast = podcast,
                    onClick = {
                        onPodcastClick(podcast)
                    }
                )
            }
        }
    }
}

@Composable
private fun PodcastSearchItem(
    podcast: Podcast,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = podcast.artworkUrl100,
            contentDescription = podcast.collectionName,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = podcast.collectionName,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = podcast.artistName,
                style = MaterialTheme.typography.bodyMedium
            )

            if (podcast.primaryGenreName.isNotBlank()) {

                Text(
                    text = podcast.primaryGenreName,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = "${podcast.trackCount} episodes",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

    HorizontalDivider()
}