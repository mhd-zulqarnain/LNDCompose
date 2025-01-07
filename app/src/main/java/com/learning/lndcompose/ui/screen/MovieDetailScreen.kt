package com.learning.lndcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.learning.lndcompose.data.Movie

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    movie: Movie?, navController: NavController
) {
    Scaffold(
        topBar = { TopBar(movie, navController) }
    ) { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    model = movie?.poster, contentDescription = null,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Title: ${movie?.title}",
                    fontSize = 14.sp
                )
            }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    movie: Movie?, navController: NavController
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                movie?.title.toString(),
                overflow = TextOverflow.Clip,
                maxLines = 1
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "movie_name",
                    movie?.title
                )
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}