package com.learning.lndcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModelProvider
import com.learning.lndcompose.data.NoteRepository
import com.learning.lndcompose.db.Note
import com.learning.lndcompose.db.NoteDB
import com.learning.lndcompose.ui.screen.NoteListDisplay
import com.learning.lndcompose.viewmodel.NoteViewmodel
import com.learning.lndcompose.viewmodel.NoteViewmodelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = NoteDB.getInstance(applicationContext)
        val repository = NoteRepository(database.noteDoa)
        val viewModelFactory = NoteViewmodelFactory(repository)
        val viewmodel = ViewModelProvider(this, viewModelFactory)[NoteViewmodel::class.java]

        viewmodel.insertNote(
            Note(
                title = "test title",
                description = "test description",
                color = "#EFA22D".toColorInt()
            )
        )
        setContent {
            val notes by viewmodel.allNotes.observeAsState(emptyList())
            NoteListDisplay(notes)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}