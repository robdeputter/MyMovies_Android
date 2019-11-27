package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.asDomainModel
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.asDatabaseModel
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.lang.Exception

class FavoritsRepository(private val _database: MyMoviesDatabase) { // meegeven van de db in de constructor => dependency injection

    val favorits: LiveData<List<MovieSerieDetail>> =
        Transformations.map(_database.favoritesDAO.getAllFavorits()) {
            it.asDomainModel()
        }//from the db

    private val _movieSerieDetail = MutableLiveData<MovieSerieDetail?>()
    val movieSerieDetail: LiveData<MovieSerieDetail?>
        get() = _movieSerieDetail

    suspend fun addFavorit(
        imdbId: String,
        rating: Float
    ) { // bij ophalen van disk --> zeer belangrijk om dit te doen op de IO-thread
        withContext(Dispatchers.IO) {
            val movieSerieDetail = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId).await()
            movieSerieDetail.favoriteRating = rating
            _database.favoritesDAO.insert(movieSerieDetail.asDatabaseModel())
        }
    }

    suspend fun getFavorit(imdbId: String): MovieSerieDetail? {
        _movieSerieDetail.value = withContext(Dispatchers.IO) {
            try {
                val obj =  _database.favoritesDAO.get(imdbId)!!.asDomainModel()
                obj

            } catch (e: Exception) {
                null
            }
        }
        return _movieSerieDetail.value
    }
    suspend fun removeFavorit(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            _database.favoritesDAO.delete(movieSerieDetail.asDatabaseModel())
        }

    }


}