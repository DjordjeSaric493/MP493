package com.example.mp493_player.player

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import com.example.mp493_player.interfaces.AudioPlayer
import com.example.mp493_player.model.PlayerState
import com.example.mp493_player.model.Track
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AndroidAudioPlayer(
    private val context: Context
): AudioPlayer {
    //prvo inicijaliyujemo ExoPlayer (glavni kurac za audoio na androidu
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    //interni mutablestateflow menja stanja i javni readonly stateflow
    private val _playerState = MutableStateFlow(PlayerState())
    override val playerState: StateFlow<PlayerState> = _playerState

    //ovde ubacujem posle logiku  i overrideujemo metode da imaaamo
    override fun loadPlaylist(tracks: List<Track>, startIndex: Int) {
        TODO("Not yet implemented")

    }

    override fun play() {
        //TODO (odrad
    }

    override fun pause() {
        TODO("Not yet implemented")
    }


}