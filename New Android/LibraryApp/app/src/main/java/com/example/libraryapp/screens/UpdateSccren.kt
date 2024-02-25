package com.example.libraryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapp.room.BookEntity
import com.example.libraryapp.viewmodel.BookViewModel

@Composable
fun UpdateScreen(viewModel: BookViewModel, bookId: String?) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var inputText by remember {
            mutableStateOf("")
        }

        Text(text = "Update the existing book", fontSize = 24.sp)

        OutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = inputText,
            onValueChange = { newText ->
                inputText = newText
            },
            label = { Text(text = "Update Text") },
            placeholder = { Text(text = "Your Update text") })

        Button(
            onClick = {
                val newBook = BookEntity(bookId!!.toInt(), inputText)
                viewModel.update(newBook)
            },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Update Book")
        }
    }

}