package com.example.mymovies.screens.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.repository.FavoritsRepository
import com.example.mymovies.repository.WatchListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * [ViewModel]
 */
class WatchlistViewModel(val database: MyMoviesDatabase) : ViewModel() {

    private val watchListRepository = WatchListRepository(database)

    /**
     * [FavoritsRepository]
     */
    val watchlistEntities = watchListRepository.watchListentities

    /**
     * [Job] => Creates a new job object in an active state.
     * A failure of any child of this job immediately causes this job to fail, too, and cancels the rest of its children.
     */
    private var job = Job()

    /**
     * [CoroutineScope] => Defines a scope for new coroutines.
     */
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    /**
     * [MutableLiveData] => value can be changed
     * Keeps track if there's a movie or serie that has been clicked
     */
    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()

    /**
     * [LiveData] is a data holder class that can be observed within a given lifecycle.
     * Keeps track if there's a movie or serie that has been clicked
     */
    val navigateToSelectedMovieSerie: LiveData<String>
        get() = _navigateToSelectedMovieSerie

    /**
     * Sets the imdbId of the clicked movie or serie
     */
    fun displayMovieSerieDetails(imdbId: String) {
        _navigateToSelectedMovieSerie.value = imdbId
    }

    /**
     * This method is called after the navigation to the detailed page
     */
    fun displayMovieSerieDetailsComplete() {
        _navigateToSelectedMovieSerie.value = null
    }

    /**
     * Calls the removeMethod from the [FavoritsRepository]
     * Is performed asynchronously on the main-thread => Database operation
     */
    fun removeFromFavorites(movieSerieDetail: MovieSerieDetail) {
        coroutineScope.launch {
            watchListRepository.removeWatchListEntity(movieSerieDetail)
        }
    }

    /**
     * [Job] needs to be cancelled
     */
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}