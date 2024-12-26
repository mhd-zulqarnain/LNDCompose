package com.learning.lndcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun ColorPicker(
    selectedColor: Color,
    onSelectColor: (Color) -> Unit
) {
    val list = listOf(
        Color("#EFA22D".toColorInt()),
        Color("#385888".toColorInt()), 
        Color("#8DB833".toColorInt()), 
        Color("#C09CC8".toColorInt()),
        Color("#9999CD".toColorInt()),
        Color("#9D5BEE".toColorInt()), 
        Color("#DE5811".toColorInt()), 
        Color("#E2EB92".toColorInt()),
        Color("#FAA385".toColorInt()) 
    )
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(list) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(it)
                    .border(
                        width = if (it == selectedColor) 2.dp else 0.dp,
                        color = if (it == selectedColor) Color.Black else Color.Transparent,
                        shape = CircleShape
                    ).clickable {
                        onSelectColor(it)
                    }
            )
        }
    }
}