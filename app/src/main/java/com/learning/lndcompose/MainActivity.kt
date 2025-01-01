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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.learning.lndcompose.data.MovieRepository
import com.learning.lndcompose.ui.screen.MovieList
import com.learning.lndcompose.viewmodel.MovieViewmodel
import com.learning.lndcompose.viewmodel.NoteViewmodelFactory


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = MovieRepository(this)
        val viewModelFactory = NoteViewmodelFactory(repository)
        val viewmodel = ViewModelProvider(this, viewModelFactory)[MovieViewmodel::class.java]

        setContent {
            Scaffold(
                floatingActionButton = { MyFab(viewmodel) }
            ) {
                val movies = viewmodel.movies
                MovieList(movies)
            }
        }
    }
}

@Composable

fun MyFab(viewModel: MovieViewmodel) {
    var showDialog by remember {
        mutableStateOf(false)
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