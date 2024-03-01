package com.example.libraryapppractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapppractice3.room.LibraryEntity
import com.example.libraryapppractice3.ui.theme.LibraryAppPractice3Theme
import com.example.libraryapppractice3.viewmodel.LibraryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppPractice3Theme {
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
fun MainScreen(viewModel: LibraryViewModel, book: LibraryEntity) {

    var inputText by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { newText ->
                inputText = newText
            },
            placeholder = { Text(text = "Enter Book Name") },
            label = { Text(text = "Book Name") })

        Button(onClick = {
            val add = LibraryEntity(0, inputText)
            viewModel.addBook(add)
        }) {
            Text(text = "Add Book")

        }
    }

}

@Composable
fun LibraryCard(book: LibraryEntity, viewModel: LibraryViewModel) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Row {
            Text(
                text = "" + book.bookId,
                fontSize = 24.sp,
                color = Color.Blue
            )

            Text(
                text = "" + book.bookName,
                fontSize = 24.sp,
                color = Color.Black
            )

            Row(horizontalArrangement = Arrangement.End) {

                IconButton(onClick = {
                    viewModel.deleteBook(book)
                }) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Book")
                }

                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit Book/${book.bookId}"
                    )
                }
            }

        }
    }

}

@Composable
fun LibraryList(viewModel: LibraryViewModel){

    val books by viewModel.allBooks.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(8.dp)) {

        Text(text = "My Library Books")

        LazyColumn{
            items(books){
                item -> LibraryCard(book = item, viewModel = viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppPractice3Theme {

    }
}