package com.learning.lndcompose.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.lndcompose.data.Movie
import com.learning.lndcompose.data.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewmodel(
    private var movieRepository: MovieRepository
) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromAPI by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromDB by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                moviesFromAPI = movieRepository.getMovies()
                movies = moviesFromAPI
                GlobalScope.launch(Dispatchers.IO) {
                    if (movieRepository.getAllMoviesFromDB().isEmpty())
                        movieRepository.insertMovieList(movies)
                }

            } catch (e: Exception) {
                Log.e("MovieViewmodel", "movies from db")
                GlobalScope.launch(Dispatchers.IO) {
                    moviesFromDB = movieRepository.getAllMoviesFromDB()
                    movies = moviesFromDB
                }
            }

        }
    }
}