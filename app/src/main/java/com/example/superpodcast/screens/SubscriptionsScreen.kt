package com.example.superpodcast.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superpodcast.model.Podcast
import com.example.superpodcast.viewmodel.SubscriptionViewModel

@Composable
fun SubscriptionsScreen(
    viewModel: SubscriptionViewModel,
    onPodcastClick: (Podcast) -> Unit
) {

    val subscriptions by
    viewModel.subscriptions.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Subscriptions",
            style = MaterialTheme.typography.headlineMedium
        )

        if (subscriptions.isEmpty()) {

            Text(
                text = "You have no subscriptions yet.",
                modifier = Modifier.padding(top = 24.dp)
            )

        } else {

            LazyColumn(
                modifier = Modifier.padding(top = 16.dp)
            ) {

                items(subscriptions) { subscription ->

                    val podcast =
                        subscription.podcast

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onPodcastClick(podcast)
                            }
                            .padding(vertical = 16.dp)
                    ) {

                        Text(
                            text = podcast.collectionName,
                            style =
                                MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = podcast.artistName
                        )

                        HorizontalDivider(
                            modifier =
                                Modifier.padding(top = 12.dp)
                        )
                    }
                }
            }
        }
    }
}