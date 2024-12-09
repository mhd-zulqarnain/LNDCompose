package com.learning.lndcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.lndcompose.data.Fruit
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
                    Content(
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
        containerColor = Color.Black,
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(modifier: Modifier = Modifier) {


    val groupList = mapOf(
        "Fruits" to listOf(
            Fruit("Apple", "its an apple", R.drawable.apple),
            Fruit("Banana", "its a banana", R.drawable.bananas),
            Fruit("Mango", "its an mango", R.drawable.mango),
            Fruit("Grapes", "its grapes", R.drawable.grapes),
        ),
        "Vegetables" to listOf(
            Fruit("Broccoli", "its a broccoli", R.drawable.brocoli),
            Fruit("Carrot", "its a carrot", R.drawable.carrot),
            Fruit("Lettuce", "its lettuce", R.drawable.lettuce),
            Fruit("Onion", "its a onion", R.drawable.onion),
            Fruit("eggplant", "its a eggplant", R.drawable.eggplant),

            ),
    )

    LazyColumn(userScrollEnabled = true, modifier = modifier) {
        groupList.forEach { (header, items) ->
            stickyHeader {
                Text(
                    header, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray).padding(16.dp),
                    fontSize = 26.sp,
                    textDecoration = TextDecoration.Underline,
                    color = Color.White

                )
            }
            items(items) { fruit ->
                CardView(fruit)
            }
        }
    }
}


@Composable
fun CardView(fruit: Fruit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                16.dp
            ),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black, disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Gray
        )
    ) {
        Column {
            Image(
                painter = painterResource(fruit.image),
                contentDescription = fruit.desc,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = fruit.name, fontWeight = FontWeight.Bold)
            Text(text = fruit.desc)

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
        val fruit = Fruit("test", "test fruit", R.drawable.carrot)
        CardView(fruit)
    }
}