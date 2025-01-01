package com.learning.lndcompose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learning.lndcompose.data.Movie


@Database(entities = [Movie::class], version = 1)
abstract class MovieDB : RoomDatabase() {
    abstract val movieDoa:MovieDoa

    companion object {
        @Volatile
        private var INSTANCE: MovieDB? = null
        fun getInstance(context: Context): MovieDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MovieDB::class.java,
                        "movie_db"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}