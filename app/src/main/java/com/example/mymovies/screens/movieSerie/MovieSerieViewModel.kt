package com.example.mymovies.screens.movieSerie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MovieSerieDAO
import com.example.mymovies.screens.movieSerie.models.MovieSerieDetail
import kotlinx.coroutines.*

 class MovieSerieViewModel(
    val database: MovieSerieDAO,
    val imdbId : String) : ViewModel(){

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _movieSerie = MutableLiveData<MovieSerieDetail>()
    val movieSerie : LiveData<MovieSerieDetail>
        get() = _movieSerie;


    //temporary = until the API call is implemented --> this has to come in the fragment
    init{
//        uiScope.launch {
//            var endGameAvengers = MovieSerieDetail("tt4154796","Avengers: Endgame",2019,"movie","","26 Apr 2019",
//                "181 min", "Action, Adventure, Drama, Sci-Fi", "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",8.5,589503)
//            database.insert(endGameAvengers);
//
//            var friends = MovieSerieDetail("tt0108778","Friends",1994,"serie","","22 Sep 1994",
//                "22 min", "Comedy, Romance", "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc",8.9,711227)
//            database.insert(friends);
//        }
        _movieSerie.value = MovieSerieDetail("tt0108778","Friends",1994,"serie","","22 Sep 1994",
        "22 min", "Comedy, Romance", "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc",8.9,711227)

    }


    fun getMovieSerieDetail() {
        uiScope.launch {
            _movieSerie.value = getMovieSerieFromDatabase()
        }
    }

    /**
     *  Handling the case of the stopped app or forgotten recording,
     *  the start and end times will be the same.j
     *
     *  If the start time and end time are not the same, then we do not have an unfinished
     *  recording.
     */

    //HIER GAAN WE EEN REQUEST DOEN NAAR DE API OM DIE BEPAALDE FILM OF SERIE TE VERKRIJGEN!!! --> daarna in de databank steken en ophalen



    private suspend fun getMovieSerieFromDatabase(): MovieSerieDetail? {
        return withContext(Dispatchers.IO) {
            var movieSerieDetail = database.get(imdbId);

            movieSerieDetail
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun update(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            database.update(movieSerieDetail)
        }
    }

    private suspend fun insert(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            database.insert(movieSerieDetail)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}