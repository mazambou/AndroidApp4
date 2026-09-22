package com.example.superpodcast.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superpodcast.data.PodcastRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class SearchViewModel(
    private val repository: PodcastRepository
) : ViewModel() {

    fun searchPodcasts(term: String) {
        viewModelScope.launch {
            repository.searchPodcasts(term)

        }
    }

}