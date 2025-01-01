package com.learning.lndcompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.learning.lndcompose.data.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(model = movie.poster, contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(16.dp)))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).fillMaxHeight()
            ) {
                Text(
                    "Title: ${movie.title}",
                    fontWeight = Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    "Year: ${movie.year}",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Type: ${movie.type}",
                    fontSize = 12.sp
                )
                Text(
                    "imdbID: ${movie.imdbID}",
                    fontSize = 11.sp
                )
            }
        }
    }
}