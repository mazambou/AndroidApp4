package com.example.superpodcast.data

import com.example.superpodcast.model.Podcast
import com.example.superpodcast.network.RetrofitClient

class PodcastRepository {

    suspend fun searchPodcasts(query: String): List<Podcast> {

        val response = RetrofitClient.api.searchPodcasts(
            searchTerm = query
        )

        return response.results
    }
}