package com.example.superpodcast.screens

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlayerScreen(
    audioUrl: String? = null
) {

    val mediaPlayer = remember {
        MediaPlayer()
    }

    val isPlaying = remember {
        mutableStateOf(false)
    }

    DisposableEffect(Unit) {

        onDispose {

            try {
                mediaPlayer.release()
            } catch (_: Exception) {
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Podcast Player",
            style = MaterialTheme.typography.headlineMedium
        )

        if (audioUrl == null) {

            Text(
                text = "Episode playback will be connected in Phase 2.",
                modifier = Modifier.padding(top = 24.dp)
            )

        } else {

            Button(
                modifier = Modifier.padding(top = 24.dp),
                onClick = {

                    try {

                        if (mediaPlayer.isPlaying) {

                            mediaPlayer.pause()

                            isPlaying.value = false

                        } else {

                            if (mediaPlayer.currentPosition > 0) {

                                mediaPlayer.start()

                            } else {

                                mediaPlayer.reset()

                                mediaPlayer.setDataSource(audioUrl)

                                mediaPlayer.prepareAsync()

                                mediaPlayer.setOnPreparedListener {
                                    it.start()

                                    isPlaying.value = true
                                }
                            }

                        }

                    } catch (exception: Exception) {

                        exception.printStackTrace()
                    }
                }
            ) {

                Text(
                    if (isPlaying.value)
                        "Pause"
                    else
                        "Play"
                )
            }
        }
    }
}