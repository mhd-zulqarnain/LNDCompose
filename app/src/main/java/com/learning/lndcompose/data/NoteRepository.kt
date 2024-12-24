package com.learning.lndcompose.data

import androidx.lifecycle.LiveData
import com.learning.lndcompose.db.Note
import com.learning.lndcompose.db.NoteDoa

class NoteRepository(private val noteDoa: NoteDoa) {

    val allNotes: LiveData<List<Note>>
        get() = noteDoa.getAllNote()


    suspend fun insertNote(note: Note) {
        return noteDoa.insert(note)
    }
}