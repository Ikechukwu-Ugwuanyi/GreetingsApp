package com.example.libraryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.libraryapp.viewmodel.BookViewModel

@Composable
fun UpdateScreen(viewModel: BookViewModel, book: String){

    Column {

        var inputText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(value = inputText,
            onValueChange = {newText ->
                inputText = newText},
            label = { Text(text = "Update Text")},
            placeholder = { Text(text = "Your Update text")})

        Button(onClick = {

        }) {

        }
    }

}