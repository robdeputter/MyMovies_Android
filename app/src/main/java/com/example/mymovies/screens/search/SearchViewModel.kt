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

/**
 * Enum to keep track of the Api status
 */
enum class MyMoviesApiStatus { LOADING, ERROR, DONE , EMPTY}

/**
 * [ViewModel]
 */
class SearchViewModel : ViewModel(){

    /**
     * Keeps track of the Api status
     */
    private val _status = MutableLiveData<MyMoviesApiStatus>();
    val status : LiveData<MyMoviesApiStatus>
        get() = _status;

    /**
     * Series and movies
     */
    private val _moviesSeries = MutableLiveData<List<MovieSerie>>();
    val movieSerieList : LiveData<List<MovieSerie>>
        get() = _moviesSeries

    /**
     * Keeps track if there's a movie or serie that has been clicked
     */
    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie : LiveData<String>
        get() = _navigateToSelectedMovieSerie


    private val _yearFilter = MutableLiveData<String>("")
    val yearFilter : LiveData<String>
        get() = _yearFilter

    private val _typeFilter = MutableLiveData<String>("")
    val typeFilter : LiveData<String>
        get() = _typeFilter


    /**
     * [Job] => Creates a new job object in an active state.
     * A failure of any child of this job immediately causes this job to fail, too, and cancels the rest of its children.
     */
    private var viewModelJob = Job();

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     *
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling
     * viewModelJob.cancel()
     */
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main);


    private var movieSerieRepository = MovieSerieRepository()


    /**
     * Default value (at the beginning) of Api status is empty
     */
    init {
        _status.value = MyMoviesApiStatus.EMPTY
    }

    /**
     * Calls getMovieSerieDetail method from [MovieSerieRepository]
     * Sets the Api status
     * Loads the [MovieSerie] object
     *
     * Is performed asynchronously on the main-thread => Network operation
     * Otherwise => can cause a bad user experience (lag)
     */
    fun getMoviesSeriesForName(name: String, year : String?, type : String?) {
         
        //why is are these MutbableLiveDataFields? --> If you change the name, the filters would disappear
        _yearFilter.value  = if (year != null) year else _yearFilter.value
        _typeFilter.value = if (type != null) type else _typeFilter.value

        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            try {
                _status.value = MyMoviesApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                _moviesSeries.value = movieSerieRepository.getMovieSeriesByFilter(name, _yearFilter.value, _typeFilter.value)
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

    /**
     * Cancels [Job]
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /**
     * Sets imdbId of clicked movie or serie
     */
    fun displayMovieSerieDetails(imdbId: String){
        _navigateToSelectedMovieSerie.value = imdbId
    }

    /**
     * Resets value after navigation
     */
    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }
}