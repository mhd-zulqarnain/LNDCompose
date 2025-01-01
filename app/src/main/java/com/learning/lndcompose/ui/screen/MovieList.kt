package com.learning.lndcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.lndcompose.data.Movie

@Composable
fun MovieList(movies: List<Movie>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(46.dp))
        Text(
            "The Movies App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Get Popular Movies",
            fontSize = 12.sp,
        )
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie)
            }
        }
    }

}