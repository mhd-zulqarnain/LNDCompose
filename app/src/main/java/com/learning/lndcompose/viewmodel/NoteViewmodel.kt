package com.learning.lndcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.lndcompose.data.NoteRepository
import com.learning.lndcompose.db.Note
import kotlinx.coroutines.launch

class NoteViewmodel(
    private var noteRepository: NoteRepository
) : ViewModel() {

    val allNotes: LiveData<List<Note>> = noteRepository.allNotes

    fun insertNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }
}