package com.example.mp493_player.model

data class Track (
    val id: String,
    val title: String,
    val artist: String,
    val mediaUrl: String,
    val durationMs: Long,
    val albumArtUrl: String? = null //sta ako npr nema onda mora dodati ?= null safety ko dart

)

