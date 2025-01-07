package com.learning.lndcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.learning.lndcompose.data.Movie
import com.learning.lndcompose.data.MovieRepository
import com.learning.lndcompose.ui.screen.MovieDetailScreen
import com.learning.lndcompose.ui.screen.MovieList
import com.learning.lndcompose.viewmodel.MovieViewmodel
import com.learning.lndcompose.viewmodel.NoteViewmodelFactory
import kotlinx.serialization.Serializable


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
                //floatingActionButton = { MyFab(viewmodel) }
            ) {
                NavigationHost(viewmodel)
            }
        }
    }
}

@Composable
fun NavigationHost(viewmodel: MovieViewmodel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            val movies = viewmodel.movies
            MovieList(movies,navController)
        }
        composable<Movie>{ backStackEntry ->
            val movie: Movie = backStackEntry.toRoute()
            MovieDetailScreen(movie,navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}

// Define a home destination that doesn't take any arguments
@Serializable
object Home

