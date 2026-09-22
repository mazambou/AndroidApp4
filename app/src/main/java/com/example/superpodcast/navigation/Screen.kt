package com.example.superpodcast.navigation

sealed class Screen(val route: String) {

    object Home : Screen("home")

    object Search : Screen("search")

    object Subscriptions : Screen("subscriptions")

    object PodcastDetail :
        Screen("podcast_detail/{podcastId}") {

        fun createRoute(podcastId: Long): String {
            return "podcast_detail/$podcastId"
        }
    }

    object Player :
        Screen("player")
}