package com.learning.lndcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.lndcompose.ui.theme.LNDComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LNDComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    bottomBar = { BottomNav() },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            Icon(Icons.Filled.Settings, contentDescription = "Settings")
                        }
                    }

                ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNav() {
    val context = LocalContext.current

    BottomAppBar(
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton({
                Toast.makeText(context, " Home icon clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Filled.Home, contentDescription = "home icon")
            }
            IconButton({
                Toast.makeText(context, " Account icon clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Filled.AccountBox, contentDescription = "account icon")
            }
            IconButton({
                Toast.makeText(context, " cart icon clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "cart icon")
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text("Top Bar") },
        colors = TopAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            scrolledContainerColor = Color.Gray,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton({
                Toast.makeText(context, " navigation icon clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "navigation icon")
            }
        },
        actions = {
            IconButton({
                Toast.makeText(context, " action icon clicked", Toast.LENGTH_LONG).show()
            }
            ) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
        },
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LNDComposeTheme {
        BottomNav()
    }
}