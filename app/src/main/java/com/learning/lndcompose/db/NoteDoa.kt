package com.learning.lndcompose.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDoa {

    @Insert
    suspend fun insert(note: Note)

    @Query("Select * from notes_table")
     fun getAllNote():LiveData<List<Note>>
}