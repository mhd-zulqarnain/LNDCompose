package com.learning.lndcompose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NoteDB : RoomDatabase() {
    abstract val noteDoa:NoteDoa

    companion object {
        @Volatile
        private var INSTANCE: NoteDB? = null
        fun getInstance(context: Context): NoteDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        NoteDB::class.java,
                        "note_db"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}