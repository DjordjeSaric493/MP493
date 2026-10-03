package com.example.mp493_player.interfaces

import com.example.mp493_player.model.PlayerState
import com.example.mp493_player.model.Track
import kotlinx.coroutines.flow.StateFlow

interface AudioPlayer {
    val playerState: StateFlow<PlayerState>
    fun loadPlaylist(tracks: List<Track>, startIndex: Int = 0)
    fun play()
    fun pause()
    fun seekTo(positionMs: Long)
    fun skipToNext()
    fun skipToPrevious()
    fun release()

}
