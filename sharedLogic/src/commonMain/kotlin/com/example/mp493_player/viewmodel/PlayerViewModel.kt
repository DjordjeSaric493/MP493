package com.example.mp493_player.viewmodel

import com.example.mp493_player.interfaces.AudioPlayer
import com.example.mp493_player.model.PlayerState
import kotlinx.coroutines.flow.StateFlow

//ovo u zagradi je primarni konstruktor

class PlayerViewModel(
    //napravi priv polje, napravi param konstruktora, dodeli vrednosti
    private val audioPlayer: AudioPlayer
) {
    val playerState: StateFlow<PlayerState> = audioPlayer.playerState

    //ovde pisem funkcije
    // - togglePlayPause()
    // - seekTo(positionMs: Long)
    // - nextTrack()
    // - previousTrack()
    fun togglePlayPause(){
        //ako traje pesma prikazi prekidac za pauzu u suprotnom za pustanke
        if(playerState.value.isPlaying){
            audioPlayer.pause()
        }else {
            audioPlayer.play()
        }
    }
    fun seekTo(positionMs: Long){
        audioPlayer.seekTo(positionMs)
    }

    fun nextTrack(){
        audioPlayer.skipToNext()
    }
    fun previousTrack(){
        audioPlayer.skipToPrevious()
    }
}
//ovde radimo separaciju odgovornosti SoC koji je instant svrsh kad pomenes na faksu ili intervjuu
//ViewModel je cist .kt kod i boli ga uvo za android ili ios
