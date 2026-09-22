package com.example.superpodcast.model

data class PodcastSearchResponse(
    val resultCount: Int = 0,
    val results: List<Podcast> = emptyList()
)
