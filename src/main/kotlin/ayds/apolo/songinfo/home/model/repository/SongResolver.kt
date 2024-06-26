package ayds.apolo.songinfo.home.model.repository

import ayds.apolo.songinfo.home.model.entities.EmptySong
import ayds.apolo.songinfo.home.model.entities.SearchResult
import ayds.apolo.songinfo.home.model.repository.external.spotify.auth.SpotifyAuthModule
import ayds.apolo.songinfo.home.model.repository.external.spotify.tracks.JsonToSongResolver
import ayds.apolo.songinfo.home.model.repository.external.spotify.tracks.SpotifyToSongResolver
import ayds.apolo.songinfo.home.model.repository.external.spotify.tracks.SpotifyTrackAPI
import ayds.apolo.songinfo.home.model.repository.external.spotify.tracks.SpotifyTrackServiceImpl
import ayds.apolo.songinfo.home.model.repository.local.spotify.SpotifyLocalCacheImpl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


class SongResolver {

    // service
    private val SPOTIFY_URL = "https://api.spotify.com/v1/"
    private val spotifyAPIRetrofit = Retrofit.Builder()
        .baseUrl(SPOTIFY_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val spotifyTrackAPI = spotifyAPIRetrofit.create(SpotifyTrackAPI::class.java)
    private val spotifyToSongResolver: SpotifyToSongResolver = JsonToSongResolver()

    val service = SpotifyTrackServiceImpl(
        spotifyTrackAPI,
        SpotifyAuthModule.spotifyAccountService,
        spotifyToSongResolver
    )

    private val db = SpotifyLocalCacheImpl()

    fun getSongByTerm(term: String): SearchResult {

        val song1 = service.getSong(term)
        val song2 = db.getSongByTerm(term)

        return if (song1 != null)
            song1.apply { println("song 1") }
        else if (song2 != null)
            song2.apply { println("song 2") }
        else EmptySong // (song1 == null && song2 == null)
    }
}