package com.example.mp493_player.model

data class PlayerState(
    val currentTrack: Track ?=null,
    val isPlaying: Boolean = false,
    val currentPositionMs: Long = 0L,
    val durationMs: Long = 0L,
    val playlist: List<Track> = emptyList(),
    val error: String?=null
)
