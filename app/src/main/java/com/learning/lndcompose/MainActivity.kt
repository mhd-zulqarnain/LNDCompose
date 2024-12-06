package com.learning.lndcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.lndcompose.ui.theme.LNDComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LNDComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    var progress by remember {
        mutableStateOf(0.1f)
    }
    Column {
        LinearProgressIndicator(
            progress = progress,
            color = Color.Green,
            trackColor = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
        Button(
            {
                progress += 0.1f

                if (progress > 1&& progress!=1.0f)
                    progress=0.0f
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Increase progress")
        }
    }


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LNDComposeTheme {
        Greeting()
    }
}