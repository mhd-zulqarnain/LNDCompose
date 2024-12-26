package com.learning.lndcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.learning.lndcompose.data.NoteRepository
import com.learning.lndcompose.db.NoteDB
import com.learning.lndcompose.ui.screen.DisplayDialog
import com.learning.lndcompose.ui.screen.NoteListDisplay
import com.learning.lndcompose.viewmodel.NoteViewmodel
import com.learning.lndcompose.viewmodel.NoteViewmodelFactory


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = NoteDB.getInstance(applicationContext)
        val repository = NoteRepository(database.noteDoa)
        val viewModelFactory = NoteViewmodelFactory(repository)
        val viewmodel = ViewModelProvider(this, viewModelFactory)[NoteViewmodel::class.java]

//        viewmodel.insertNote(
//            Note(
//                title = "test title",
//                description = "test description",
//                color = "#EFA22D".toColorInt()
//            )
//        )
        setContent {
            Scaffold(
                floatingActionButton = { MyFab(viewmodel) }
            ) {
                val notes by viewmodel.allNotes.observeAsState(emptyList())
                NoteListDisplay(notes)
            }
        }
    }
}

@Composable

fun MyFab(viewModel: NoteViewmodel) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    DisplayDialog(viewModel, showDialog) {
        showDialog = false
    }
    FloatingActionButton(
        onClick = {
            showDialog = true

        },
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}