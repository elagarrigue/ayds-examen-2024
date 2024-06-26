package ayds.apolo.songinfo.home.model.repository.local.spotify

import ayds.apolo.songinfo.home.model.entities.SpotifySong

interface SpotifyLocalStorage {

    fun getSongByTerm(term: String): SpotifySong?

    fun insertSong(term: String, song: SpotifySong)

    fun deleteSong(term: String)

}