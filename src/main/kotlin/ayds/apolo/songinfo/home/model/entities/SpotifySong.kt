package ayds.apolo.songinfo.home.model.entities

interface SearchResult
data class SpotifySong(
  val id: String,
  val songName: String,
  val artistName: String,
  val albumName: String,
  val releaseDate: String,
  val spotifyUrl: String,
  val imageUrl: String,
) : SearchResult {

  val year: String = releaseDate.split("-").first()
}

object EmptySong : SearchResult