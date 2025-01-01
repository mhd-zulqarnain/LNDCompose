package com.learning.lndcompose.data

import android.content.Context
import com.learning.lndcompose.db.MovieDB
import com.learning.lndcompose.db.MovieDoa
import com.learning.lndcompose.retrofit.RetrofitInstance

class MovieRepository(context: Context) {

    private val db = MovieDB.getInstance(context)
    private val movieDoa: MovieDoa = db.movieDoa


     fun getAllMoviesFromDB() :List<Movie> = movieDoa.getAllMovies()

    suspend fun insertNote(movie: Movie) {
        return movieDoa.insertMovie(movie)
    }

    suspend fun insertMovieList(movies: List<Movie>) {
        return movieDoa.insertMovieList(movies)
    }

    suspend fun getMovies(): List<Movie> =
        RetrofitInstance.api
            .getMovies("9df7076", "2", "Batman").movies
}