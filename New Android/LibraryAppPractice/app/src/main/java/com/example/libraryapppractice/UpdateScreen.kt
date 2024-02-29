package com.example.libraryapppractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapppractice.room.BooKEntity
import com.example.libraryapppractice.viewmodel.BookViewModel

@Composable
fun UpdateScreen(bookViewModel: BookViewModel, bookId: String?){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Updating the Existing Book", fontSize = 24.sp)

        var newText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(value = newText,
            onValueChange = {updateText -> newText = updateText},
            label = { Text(text = "Update Text")},
            placeholder = {Text(text = "Enter Text")},
            modifier = Modifier.padding(16.dp))

        Button(onClick = {
            val bookRef = bookId!!.toInt()
            bookViewModel.updateBook(BooKEntity(bookRef, newText))
        }) {
            Text(text = "Update Book")
        }
    }

}