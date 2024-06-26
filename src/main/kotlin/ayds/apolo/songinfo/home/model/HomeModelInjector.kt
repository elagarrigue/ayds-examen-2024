package ayds.apolo.songinfo.home.model

import ayds.apolo.songinfo.home.model.repository.SongResolver

object HomeModelInjector {

  private val repository: SongResolver = SongResolver()

  val homeModel: HomeModel = HomeModelImpl(repository)
}