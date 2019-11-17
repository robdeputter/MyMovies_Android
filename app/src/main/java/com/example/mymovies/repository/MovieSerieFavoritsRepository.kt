package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.MovieSerieFavoritsDatabase
import com.example.mymovies.database.asDomainModel
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieSerieFavoritsRepository(private val _database: MovieSerieFavoritsDatabase){ // meegeven van de db in de constructor => dependency injection

    val favorits : LiveData<List<MovieSerieDetail>> =  Transformations.map(_database.movieSerieDAO.getAllFavorits()) {
        it.asDomainModel()
    }//from the db



    suspend fun addFavorit(imdbId: String){ // bij ophalen van disk --> zeer belangrijk om dit te doen op de IO-thread
        withContext(Dispatchers.IO){
            val movieSerieDetail = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId).await()
            _database.movieSerieDAO.insert(movieSerieDetail.asDatabaseModel())
        }
    }


}