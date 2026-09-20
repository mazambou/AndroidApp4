package com.example.superpodcast.viewmodel

import androidx.lifecycle.ViewModel
import com.example.superpodcast.data.SubscriptionRepository
import com.example.superpodcast.model.Podcast
import com.example.superpodcast.model.Subscription
import kotlinx.coroutines.flow.StateFlow

class SubscriptionViewModel : ViewModel() {

    val subscriptions: StateFlow<List<Subscription>> =
        SubscriptionRepository.subscriptions

    fun subscribe(podcast: Podcast) {
        SubscriptionRepository.subscribe(podcast)
    }

    fun unsubscribe(podcastId: Long) {
        SubscriptionRepository.unsubscribe(podcastId)
    }

    fun isSubscribed(podcastId: Long): Boolean {
        return SubscriptionRepository.isSubscribed(podcastId)
    }
}