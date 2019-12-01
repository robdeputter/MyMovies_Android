package com.example.mymovies.screens.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.repository.MovieSerieRepository
import com.squareup.moshi.JsonDataException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class MyMoviesApiStatus { LOADING, ERROR, DONE , EMPTY}

class SearchViewModel : ViewModel(){

    private val _status = MutableLiveData<MyMoviesApiStatus>();
    val status : LiveData<MyMoviesApiStatus>
        get() = _status;

    private val _moviesSeries = MutableLiveData<List<MovieSerie>>();
    val movieSerieList : LiveData<List<MovieSerie>>
        get() = _moviesSeries

    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie : LiveData<String>
        get() = _navigateToSelectedMovieSerie

    private val yearFilter = MutableLiveData<String>("")
    private val typeFilter = MutableLiveData<String>("")

    private var viewModelJob = Job();

    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main);

    private var movieSerieRepository = MovieSerieRepository()

    init {
        _status.value = MyMoviesApiStatus.EMPTY
    }

    fun getMoviesSeriesForName(name: String, year : String?, type : String?) {
         
        //why is are these MutbableLiveDataFields? --> If you change the name, the filters would disappear
        yearFilter.value  = if (year != null) year else yearFilter.value
        typeFilter.value = if (type != null) type else typeFilter.value

        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            try {
                _status.value = MyMoviesApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                _moviesSeries.value = movieSerieRepository.getMovieSeriesByFilter(name, yearFilter.value, typeFilter.value)
                _status.value = MyMoviesApiStatus.DONE
            } catch (jsond: JsonDataException) {
                _moviesSeries.value = ArrayList()
                _status.value = MyMoviesApiStatus.EMPTY
            }
            catch (e: Exception) {
                _status.value = MyMoviesApiStatus.ERROR
                _moviesSeries.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayMovieSerieDetails(imdbId: String){
        _navigateToSelectedMovieSerie.value = imdbId
    }

    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }
}