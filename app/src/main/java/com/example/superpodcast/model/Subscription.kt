package com.example.superpodcast.model

data class Subscription(
    val podcast: Podcast,
    val subscribedAt: Long = System.currentTimeMillis()
)