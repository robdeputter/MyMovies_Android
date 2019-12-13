package com.example.mymovies.screens.newRelease

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.repository.NewReleasesRepository
import com.example.mymovies.screens.search.MyMoviesApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.cancel

/**
 * [ViewModel]
 */
class NewReleaseViewModel(private val _database: MyMoviesDatabase) : ViewModel() {

    /**
     * Instance of [NewReleasesRepository]
     */
    private val newReleaseRepository = NewReleasesRepository(_database)

    /**
     * Keeps track of the Api status
     */
    private val _status = MutableLiveData<MyMoviesApiStatus>()
    val status: LiveData<MyMoviesApiStatus>
        get() = _status

    /**
     * [Job] => Creates a new job object in an active state.
     * A failure of any child of this job immediately causes this job to fail, too, and cancels the rest of its children.
     */
    private val viewModelJob = Job()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     *
     * [CoroutineScope] => Defines a scope for new coroutines.
     */
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Refreshes the new releases at the construcion of the viewmodel
     */
    init {
        viewModelScope.launch {
            newReleaseRepository.refreshNewReleases()
        }
    }

    /**
     * Loads the new Releases from the database
     */
    val newReleases = newReleaseRepository.newReleases

    /**
     * Keeps track if there's a movie or serie that has been clicked
     */
    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie: LiveData<String>
        get() = _navigateToSelectedMovieSerie

    /**
     * Sets the imdId value of the clicked item
     */
    fun displayMovieSerieDetails(imdbId: String) {
        _navigateToSelectedMovieSerie.value = imdbId
    }

    /**
     * Reset to null if the navigation is complete
     */
    fun displayMovieSerieDetailsComplete() {
        _navigateToSelectedMovieSerie.value = null
    }

    /**
     * Cancels [Job]
     */
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}