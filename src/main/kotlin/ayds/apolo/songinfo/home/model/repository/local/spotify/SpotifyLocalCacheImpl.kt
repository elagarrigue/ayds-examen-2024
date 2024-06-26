package ayds.apolo.songinfo.home.model.repository.local.spotify

import ayds.apolo.songinfo.home.model.entities.SpotifySong

internal class SpotifyLocalCacheImpl : SpotifyLocalStorage {

    private val songs = mutableMapOf<String, SpotifySong>()

    override fun insertSong(term: String, song: SpotifySong) {
        songs[term] = song
    }
    
    override fun getSongByTerm(term: String): SpotifySong? = songs[term]
    
    override fun deleteSong(term: String) {
        songs.remove(term)
    }

}