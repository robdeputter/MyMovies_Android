package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.repository.FavoritsRepository
import com.example.mymovies.repository.MovieSerieDetailRepository
import com.example.mymovies.repository.WatchListRepository
import com.example.mymovies.screens.search.MyMoviesApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * [ViewModel]
 */
class MovieSerieViewModel(
    val imdbId: String,
    val application: Application
) : ViewModel() {

    /**
     * Keeps track of the Api status
     */
    private val _status = MutableLiveData<MyMoviesApiStatus>()
    val status: LiveData<MyMoviesApiStatus>
        get() = _status

    /**
     * The movie or serie that is showed
     */
    private var _movieSerieDetail = MutableLiveData<MovieSerieDetail>()
    val movieSerie: LiveData<MovieSerieDetail>
        get() = _movieSerieDetail

    /**
     * Keeps track if the [movieSerie] is in favorites
     */
    private var _inFavorits = MutableLiveData<Boolean>()
    val inFavorits: LiveData<Boolean>
        get() = _inFavorits

    /**
     * Keeps track if the [movieSerie] is in watchList
     */
    private var _inWatchlist = MutableLiveData<Boolean>()
    val inWatchlist: LiveData<Boolean>
        get() = _inWatchlist

    /**
     * Keeps track if a Snackbar for favorites has to be shown
     */
    private var _showSnackbarEventFavorites = MutableLiveData<Boolean>()
    val showSnackbarEventFavorites: LiveData<Boolean>
        get() = _showSnackbarEventFavorites

    /**
     * Keeps track if a Snackbar for favorites has to be shown
     */
    private var _showSnackbarEventWatchlist = MutableLiveData<Boolean>()
    val showSnackbarEventWatchlist: LiveData<Boolean>
        get() = _showSnackbarEventWatchlist

    /**
     * [MovieSerieDetailRepository]
     */
    private val movieSerieRepository = MovieSerieDetailRepository()
    private val favoritsRepository =
        FavoritsRepository(MyMoviesDatabase.getInstance(application.applicationContext))
    private val watchListRepository =
        WatchListRepository(MyMoviesDatabase.getInstance(application.applicationContext))

    /**
     * [Job] => Creates a new job object in an active state.
     * A failure of any child of this job immediately causes this job to fail, too, and cancels the rest of its children.
     */
    private var job = Job()

    /**
     * [CoroutineScope] => Defines a scope for new coroutines.
     */
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    init {
        getMovieSerieDetailObject()
    }

    /**
     * Calls getMovieSerieDetail method from [MovieSerieDetailRepository]
     * Sets the Api status
     * Loads the [MovieSerieDetail] object
     *
     * Is performed asynchronously on the main-thread => Network operation
     * Otherwise => can cause a bad user experience (lag)
     */
    private fun getMovieSerieDetailObject() {
        coroutineScope.launch {
            try {
                _status.value = MyMoviesApiStatus.LOADING
                if (favoritsRepository.getFavorit(imdbId) == null && watchListRepository.getWatchListentity(
                        imdbId
                    ) == null
                ) {
                    _inFavorits.value = false
                    _inWatchlist.value = false
                    _movieSerieDetail.value =
                        movieSerieRepository.getMovieSerieDetail(imdbId)
                } else if (favoritsRepository.getFavorit(imdbId) != null) {
                    _inFavorits.value = true
                    _inWatchlist.value = watchListRepository.getWatchListentity(imdbId) != null
                    _movieSerieDetail.value = favoritsRepository.getFavorit(imdbId)
                } else if (watchListRepository.getWatchListentity(imdbId) != null) {
                    _inFavorits.value = false
                    _inWatchlist.value = true
                    _movieSerieDetail.value = watchListRepository.getWatchListentity(imdbId)
                }
                _status.value = MyMoviesApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MyMoviesApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }

    /**
     * Calls the addFavoriteMethod from the [FavoritsRepository]
     * Is performed asynchronously on the main-thread => Database operation
     *
     * Reloads the [MovieSerieDetail] object to renew check if object is in favorites
     */
    fun addToFavorits(rating: Float) {
        coroutineScope.launch {
            favoritsRepository.addFavorit(imdbId, rating)
            _showSnackbarEventFavorites.value = true
            // reloading
            _inFavorits.value = true
        }
    }

    /**
     * Calls the removeMethod from the [FavoritsRepository]
     * Is performed asynchronously on the main-thread => Database operation
     *
     * Reloads the [MovieSerieDetail] object to renew check if object is in favorites
     */
    fun removeFromFavorits() {
        coroutineScope.launch {
            favoritsRepository.removeFavorit(_movieSerieDetail.value!!)
            _showSnackbarEventFavorites.value = true
            // reloading
            _inFavorits.value = false
        }
    }

    /**
     * Calls the addFavoriteMethod from the [WatchListRepository]
     * Is performed asynchronously on the main-thread => Database operation
     *
     * Reloads the [MovieSerieDetail] object to renew check if object is in watchlist
     */
    fun addToWatchlist() {
        coroutineScope.launch {
            watchListRepository.addToWatchList(imdbId)
            _showSnackbarEventWatchlist.value = true
            // reloading
            _inWatchlist.value = true
        }
    }

    /**
     * Calls the removeMethod from the [WatchListRepository]
     * Is performed asynchronously on the main-thread => Database operation
     *
     * Reloads the [MovieSerieDetail] object to renew check if object is in watchlist
     */
    fun removeFromWatchlist() {
        coroutineScope.launch {
            watchListRepository.removeWatchListEntity(_movieSerieDetail.value!!)
            _showSnackbarEventWatchlist.value = true
            // reloading
            _inWatchlist.value = false
        }
    }

    /**
     * Sets showSnackbarFavorites to false
     */
    fun doneShowingSnackbarFavorites() {
        _showSnackbarEventFavorites.value = false
    }

    /**
     * Sets showSnackbar to false
     */
    fun doneShowingSnackbarWatchlist() {
        _showSnackbarEventWatchlist.value = false
    }

    /**
     * Cancels [Job]
     */
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}