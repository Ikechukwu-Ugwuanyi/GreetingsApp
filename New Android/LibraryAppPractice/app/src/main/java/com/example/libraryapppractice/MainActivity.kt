package com.example.libraryapppractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.sp
import com.example.libraryapppractice.room.BooKEntity
import com.example.libraryapppractice.ui.theme.LibraryAppPracticeTheme
import com.example.libraryapppractice.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun MainScreen(bookViewModel: BookViewModel){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)) {

        var inputText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = inputText,
            onValueChange = {newText -> inputText = newText},
            label = { Text(text = "Enter Book Name")},
            placeholder = { Text(text = "Enter Book Name")})

        Button(onClick = {
            val add = BooKEntity(0, inputText)
            bookViewModel.addBook(add)
        }) {
            Text(text = "Add Book to DB")
        }
    }

    @Composable
    fun BookCard(bookViewModel: BookViewModel, booKEntity: BooKEntity){

        Card(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
            Row {
                Text(text = booKEntity.bookTitle,
                    fontSize = 24.sp)

                Row (horizontalArrangement = Arrangement.End,
                    modifier = Modifier.padding(4.dp)){
                    IconButton(onClick = {
                        bookViewModel.deleteBook(booKEntity)
                    }) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Icon")
                    }

                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Icon")
                    }

                }
            }
        }
    }

    @Composable



}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppPracticeTheme {

    }
}