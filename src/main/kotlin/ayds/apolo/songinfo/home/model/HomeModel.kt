package ayds.apolo.songinfo.home.model

import ayds.apolo.songinfo.home.model.entities.SearchResult
import ayds.apolo.songinfo.home.model.repository.SongResolver
import ayds.observer.Observable
import ayds.observer.Subject

interface HomeModel {

    val resultObservable: Observable<SearchResult>

    fun searchSong(term: String)
}

internal class HomeModelImpl(
    private val repository: SongResolver
) : HomeModel {

    private val resultSubject = Subject<SearchResult>()

    override val resultObservable: Observable<SearchResult> = resultSubject

    override fun searchSong(term: String) {
        val result = repository.getSongByTerm(term)

        resultSubject.notify(result)
    }
}