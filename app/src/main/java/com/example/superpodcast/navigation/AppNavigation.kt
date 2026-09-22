package com.example.superpodcast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superpodcast.screens.HomeScreen
import com.example.superpodcast.screens.PlayerScreen
import com.example.superpodcast.screens.PodcastDetailScreen
import com.example.superpodcast.screens.SearchScreen
import com.example.superpodcast.screens.SubscriptionsScreen
import com.example.superpodcast.viewmodel.PodcastViewModel
import com.example.superpodcast.viewmodel.SubscriptionViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val podcastViewModel: PodcastViewModel = viewModel()
    val subscriptionViewModel: SubscriptionViewModel = viewModel()

    val subscriptions by subscriptionViewModel.subscriptions.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        // Home Screen
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                },

                onSubscriptionsClick = {
                    navController.navigate(Screen.Subscriptions.route)
                }
            )
        }

        // Search Screen
        composable(
            route = Screen.Search.route
        ) {
            SearchScreen(
                viewModel = podcastViewModel,

                onPodcastClick = { podcast ->
                    navController.navigate(
                        Screen.PodcastDetail.createRoute(
                            podcast.collectionId
                        )
                    )
                }
            )
        }

        // Podcast Detail Screen
        composable(
            route = Screen.PodcastDetail.route,
            arguments = listOf(
                navArgument("podcastId") {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->

            val podcastId =
                backStackEntry.arguments?.getLong("podcastId")

            val podcast =
                podcastId?.let {
                    podcastViewModel.getPodcastById(it)
                }

            val isSubscribed =
                podcast?.let { currentPodcast ->

                    subscriptions.any { subscription ->
                        subscription.podcast.collectionId ==
                                currentPodcast.collectionId
                    }

                } ?: false

            PodcastDetailScreen(
                podcast = podcast,

                isSubscribed = isSubscribed,

                onSubscribe = { selectedPodcast ->
                    subscriptionViewModel.subscribe(
                        selectedPodcast
                    )
                },

                onUnsubscribe = { podcastIdToRemove ->
                    subscriptionViewModel.unsubscribe(
                        podcastIdToRemove
                    )
                },

                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Subscriptions Screen
        composable(
            route = Screen.Subscriptions.route
        ) {
            SubscriptionsScreen(
                viewModel = subscriptionViewModel,

                onPodcastClick = { podcast ->
                    navController.navigate(
                        Screen.PodcastDetail.createRoute(
                            podcast.collectionId
                        )
                    )
                }
            )
        }

        // Player Screen
        composable(
            route = Screen.Player.route
        ) {
            PlayerScreen()
        }
    }
}