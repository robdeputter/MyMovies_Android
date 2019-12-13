package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.asDomainModel_NewRelease
import com.example.mymovies.models.NewRelease
import com.example.mymovies.network.NewReleasesApi
import com.example.mymovies.network.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Responsible for getting [NewRelease] objects
 */
class NewReleasesRepository(private val _database: MyMoviesDatabase) {

    /**
     * Get all the new releases that are currently in the database
     *
     * [LiveData] => LiveData is a data holder class that can be observed within a given lifecycle.
     * This means that an {@link Observer} can be added in a pair with a {@link LifecycleOwner}, and
     * this observer will be notified about modifications of the wrapped data only if the paired
     */
    val newReleases: LiveData<List<NewRelease>> =
        Transformations.map(_database.newReleasesDAO.getAllNewReleases()) {
            it.asDomainModel_NewRelease()
        }

    /**
     * Refresh the database objects by the objects from the network (back-end)
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun refreshNewReleases() {
        withContext(Dispatchers.IO) {
            // getting the objects from the API
            val obj = NewReleasesApi.retrofitService.getNewReleases()
            val newReleases = NewReleasesApi.retrofitService.getNewReleases().await()
            // save in the DB
            _database.newReleasesDAO.insertAll(*newReleases.ITEMS.asDatabaseModel())
        }
    }
}