package com.example.mymovies.screens.newRelease

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.database.MyMoviesDatabase

/**
 * Responsible for creating a [NewReleaseViewModel] instance
 */
class NewReleaseViewModelFactory(
    val application: Application,
    val database: MyMoviesDatabase
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewReleaseViewModel::class.java)) {
            return NewReleaseViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}