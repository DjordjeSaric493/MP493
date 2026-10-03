package com.example.mp493_player

import com.example.mp493_player.interfaces.AudioPlayer
import com.example.mp493_player.model.PlayerState
import com.example.mp493_player.model.Track
import com.example.mp493_player.viewmodel.PlayerViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.StateFlow
class SharedLogicCommonTest {

    @Test
    fun example() {
        assertEquals(3, 1 + 2)
    }
}

class FakeAudioPlayer : AudioPlayer{
    private val _playerState = MutableStateFlow(PlayerState())
    override val  playerState: StateFlow<PlayerState> = _playerState


    //var i val kao sto skracenice kazu var promenljivo , val nije
    var playCalledCount = 0 //pocetne vrednosti
    var pauseCalledCount = 0

    override fun loadPlaylist(
        tracks: List<Track>,
        startIndex: Int
    ) {
        _playerState.value = _playerState.value.copy(
            playlist = tracks,
            currentTrack = tracks.getOrNull(startIndex)
        )
    }

    override fun play() {
        playCalledCount++
        _playerState.value = _playerState.value.copy(isPlaying = true)
    }

    override fun pause() {
        pauseCalledCount++
        _playerState.value = _playerState.value.copy(isPlaying = false)
    }

    override fun seekTo(positionMs: Long) {
        _playerState.value= _playerState.value.copy(currentPositionMs = positionMs)

    }

    override fun skipToNext() {
       //ovo neka bude za simulaciju promene
    }

    override fun skipToPrevious() {
        //TODO("Not yet implemented")
    }

    override fun release() {
      //  TODO("Not yet implemented")
    }

    class PlayerViewModelTest {

        @Test
        fun testTogglePlayPause() {
            val fakePlayer = FakeAudioPlayer()
            val viewModel = PlayerViewModel(fakePlayer)

            // Početno stanje: ne pusta
            assertEquals(false, viewModel.playerState.value.isPlaying)

            // Pozivamo toggle -> treba da pokrene plejer
            viewModel.togglePlayPause()
            assertEquals(true, fakePlayer.playCalledCount == 1)
            assertEquals(true, viewModel.playerState.value.isPlaying)

            // Ponovo pozivamo toggle -> treba da pauzira
            viewModel.togglePlayPause()
            assertEquals(true, fakePlayer.pauseCalledCount == 1)
            assertEquals(false, viewModel.playerState.value.isPlaying)
        }
    }

}