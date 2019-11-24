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
import kotlinx.coroutines.withContext
import java.lang.Exception

class FavoritsRepository(private val _database: MyMoviesDatabase) { // meegeven van de db in de constructor => dependency injection

    val favorits: LiveData<List<MovieSerieDetail>> =
        Transformations.map(_database.favoritesDAO.getAllFavorits()) {
            it.asDomainModel()
        }//from the db


    suspend fun addFavorit(imdbId: String) { // bij ophalen van disk --> zeer belangrijk om dit te doen op de IO-thread
        withContext(Dispatchers.IO) {
            val movieSerieDetail = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId).await()
            _database.favoritesDAO.insert(movieSerieDetail.asDatabaseModel())
        }
    }

    fun getFavorit(imdbId: String): MovieSerieDetail? {
        try {
            return _database.favoritesDAO.get(imdbId)!!.asDomainModel()
        } catch (e: Exception) {
            return null
        }

    }

    suspend fun removeFavorit(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            _database.favoritesDAO.delete(movieSerieDetail.asDatabaseModel())
        }

    }


}