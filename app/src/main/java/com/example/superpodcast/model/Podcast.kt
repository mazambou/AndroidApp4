package com.example.superpodcast.model

data class Podcast(
    val collectionId: Long = 0,
    val collectionName: String = "",
    val artistName: String = "",
    val artworkUrl100: String = "",
    val feedUrl: String? = null,
    val trackCount: Int = 0,
    val primaryGenreName: String = "",
    val country: String = ""
)

