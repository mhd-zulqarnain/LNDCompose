package com.learning.lndcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    var checked by remember {
        mutableStateOf("option 1")
    }

    Column {
        RadioButtonText(
            selected = checked == "option 1", {
                checked = "option 1"
            }, "option 1"

        )
        RadioButtonText(
            selected = checked == "option 2", {
                checked = "option 2"
            }, "option 2"
        )
    }

}


@Composable
fun RadioButtonText(
    selected: Boolean,
    checked: () -> Unit,
    label: String
) {
    Row (verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(8.dp)){
        RadioButton(
            selected = selected, checked
        )
        Text(label)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LNDComposeTheme {
        Greeting()
    }
}