package com.example.mymovies.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Responsible for creating a [SearchViewModel] instance
 */
class SearchViewModelFactory : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}