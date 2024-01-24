package kr.ac.kumoh.ce.prof01.jet14lazycolumn

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Song(var title: String, var singer: String)

class SongViewModel : ViewModel() {
    private val _songs = mutableStateListOf<Song>()
    val songs: List<Song>
        get() = _songs

    fun add(song: Song) {
        _songs.add(song)
    }

}