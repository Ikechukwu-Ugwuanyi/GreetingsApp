package com.example.libraryapppractice3

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.libraryapppractice3.room.LibraryEntity
import com.example.libraryapppractice3.viewmodel.LibraryViewModel

@Composable
fun UpdateScreen(viewModel: LibraryViewModel, bookId: String?){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Update the Existing Book", fontSize = 24.sp)

        var updateText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(value = updateText,
            onValueChange = {newText -> updateText = newText},
            label = { Text(text = "Enter Update Text")},
            placeholder = { Text(text = "Your Text")})

        Button(onClick = {
            val bookRef = bookId!!.toInt()
            viewModel.update(LibraryEntity(bookRef, updateText))
        }) {
            Text(text = "Update Book")
        }
    }
}