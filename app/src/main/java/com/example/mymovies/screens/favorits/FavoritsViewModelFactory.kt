package com.example.mymovies.screens.favorits

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.database.FavoritsDatabase

class  FavoritsViewModelFactory(val application: Application,
                                val database: FavoritsDatabase) : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritsViewModel::class.java)) {
            return FavoritsViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}