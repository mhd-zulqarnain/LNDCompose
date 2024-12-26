package com.learning.lndcompose.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.learning.lndcompose.db.Note
import com.learning.lndcompose.viewmodel.NoteViewmodel

@Composable
fun DisplayDialog(
    viewModel: NoteViewmodel,
    show: Boolean,
    onDismiss: () -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var selectedColor by remember {
        mutableStateOf(Color.Magenta)
    }

    if (show)
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Add notes") },
            text = {
                Column {
                    TextField(value = title,
                        onValueChange = { title = it },
                        label = { Text("Note title ") })

                    Spacer(modifier = Modifier.height(3.dp))

                    TextField(value = description,
                        onValueChange = { description = it },
                        label = { Text("Note description  ") })

                    ColorPicker(selectedColor, {
                        selectedColor = it
                    })
                }
            },
            confirmButton = {
                Button({
                    val note = Note(
                        title = title,
                        description = description,
                        color = selectedColor.toArgb()
                    )
                    viewModel.insertNote(note)
                    onDismiss.invoke()
                    title = ""
                    description = ""
                }) {
                    Text("Save note")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Cancel ")
                }
            }
        )
}