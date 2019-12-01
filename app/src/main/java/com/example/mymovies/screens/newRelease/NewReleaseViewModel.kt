package com.example.mymovies.screens.newRelease

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.models.NewRelease
import com.example.mymovies.repository.NewReleasesRepository
import com.example.mymovies.screens.search.MyMoviesApiStatus
import kotlinx.coroutines.*

class NewReleaseViewModel(private val _database : MyMoviesDatabase) : ViewModel(){


    private val newReleaseRepository = NewReleasesRepository(_database)

    private val viewModelJob = SupervisorJob()

    private val _status = MutableLiveData<MyMoviesApiStatus>()
    val status : LiveData<MyMoviesApiStatus>
        get() = _status

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     *
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling
     * viewModelJob.cancel()
     */
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        viewModelScope.launch {
            newReleaseRepository.refreshNewReleases()
        }
    }

    val newReleases = newReleaseRepository.newReleases

    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie : LiveData<String>
        get() = _navigateToSelectedMovieSerie

    fun displayMovieSerieDetails(imdbId: String){
        _navigateToSelectedMovieSerie.value = imdbId
    }

    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}