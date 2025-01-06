package com.learning.lndcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.learning.lndcompose.data.Movie

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(movie: Movie?) {

    Scaffold(
        //floatingActionButton = { MyFab(viewmodel) }
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .padding(start = 12.dp, top = 40.dp, end = 12.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {

                AsyncImage(
                    model = movie?.poster, contentDescription = null,
                    modifier = Modifier.clip(
                        RoundedCornerShape(16.dp)
                    )
                )
                Text(
                    "Title: ${movie?.title}",
                    fontWeight = Bold,
                    fontSize = 14.sp
                )
            }
        }
    }


}