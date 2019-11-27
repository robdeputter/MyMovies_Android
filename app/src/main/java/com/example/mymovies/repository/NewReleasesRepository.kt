package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.asDomainModel_NewRelease
import com.example.mymovies.models.NewRelease
import com.example.mymovies.models.NewReleaseResponse
import com.example.mymovies.network.NewReleasesApi
import com.example.mymovies.network.NewReleasesApiService
import com.example.mymovies.network.asDatabaseModel
import com.example.mymovies.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewReleasesRepository(private val _database : MyMoviesDatabase) {

    val newReleases : LiveData<List<NewRelease>> = Transformations.map(_database.newReleasesDAO.getAllNewReleases()){
        it.asDomainModel_NewRelease()
    }

    suspend fun refreshNewReleases() {
        withContext(Dispatchers.IO) {
            //getting the objects from the API
            val obj = NewReleasesApi.retrofitService.getNewReleases()
            val newReleases = NewReleasesApi.retrofitService.getNewReleases().await()
            //save in the DB
            _database.newReleasesDAO.insertAll(*newReleases.ITEMS.asDatabaseModel())}
    }
}