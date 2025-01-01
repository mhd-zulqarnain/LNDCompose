package com.learning.lndcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.lndcompose.data.MovieRepository

@Suppress("UNCHECKED_CAST")
class NoteViewmodelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewmodel::class.java)) {
            return MovieViewmodel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown model class")
    }
}