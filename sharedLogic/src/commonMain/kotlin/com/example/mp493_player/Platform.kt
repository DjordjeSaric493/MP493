package com.example.mp493_player

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform