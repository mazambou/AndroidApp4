package com.example.superpodcast.network

import com.example.superpodcast.model.PodcastSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApiService {

    @GET("search")
    suspend fun searchPodcasts(
        @Query("term") searchTerm: String,
        @Query("media") media: String = "podcast",
        @Query("entity") entity: String = "podcast",
        @Query("limit") limit: Int = 50
    ): PodcastSearchResponse
}