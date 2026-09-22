package com.example.superpodcast.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superpodcast.data.PodcastRepository
import com.example.superpodcast.model.Podcast
import kotlinx.coroutines.launch

class PodcastViewModel(
    private val repository: PodcastRepository = PodcastRepository()
) : ViewModel() {

    var podcasts by mutableStateOf<List<Podcast>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun searchPodcasts(query: String) {

        if (query.isBlank()) {
            return
        }

        viewModelScope.launch {

            isLoading = true
            errorMessage = null

            try {

                podcasts = repository.searchPodcasts(query)

            } catch (exception: Exception) {

                errorMessage =
                    exception.message ?: "Unable to load podcasts."

            } finally {

                isLoading = false
            }
        }
    }

    fun getPodcastById(id: Long): Podcast? {

        return podcasts.find {
            it.collectionId == id
        }
    }
}