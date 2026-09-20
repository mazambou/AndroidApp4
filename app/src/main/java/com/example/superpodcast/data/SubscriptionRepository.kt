package com.example.superpodcast.data

import com.example.superpodcast.model.Podcast
import com.example.superpodcast.model.Subscription
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object SubscriptionRepository {

    private val _subscriptions =
        MutableStateFlow<List<Subscription>>(emptyList())

    val subscriptions: StateFlow<List<Subscription>> =
        _subscriptions

    fun subscribe(podcast: Podcast) {

        if (!isSubscribed(podcast.collectionId)) {

            val subscription = Subscription(
                podcast = podcast
            )

            _subscriptions.value =
                _subscriptions.value + subscription
        }
    }

    fun unsubscribe(podcastId: Long) {

        _subscriptions.value =
            _subscriptions.value.filter {
                it.podcast.collectionId != podcastId
            }
    }

    fun isSubscribed(podcastId: Long): Boolean {

        return _subscriptions.value.any {
            it.podcast.collectionId == podcastId
        }
    }
}