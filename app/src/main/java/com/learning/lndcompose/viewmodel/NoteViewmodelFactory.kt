package com.learning.lndcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.lndcompose.data.NoteRepository

@Suppress("UNCHECKED_CAST")
class NoteViewmodelFactory(val noteRepository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewmodel::class.java)) {

            return NoteViewmodel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown model class")
    }
}