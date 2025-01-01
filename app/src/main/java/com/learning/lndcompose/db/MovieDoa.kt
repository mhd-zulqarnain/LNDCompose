package com.learning.lndcompose.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learning.lndcompose.data.Movie

@Dao
interface MovieDoa {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert
    suspend fun insertMovieList(movies: List<Movie>)

    @Query("Select * from movies_table")
     fun getAllMovies():List<Movie>
}