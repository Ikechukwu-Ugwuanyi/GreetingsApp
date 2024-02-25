package com.example.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.repository.BookRepository
import com.example.libraryapp.room.BookEntity
import com.example.libraryapp.room.BooksDB
import com.example.libraryapp.screens.UpdateScreen
import com.example.libraryapp.ui.theme.LibraryAppTheme
import com.example.libraryapp.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mContext = LocalContext.current
                    val db = BooksDB.getInstance(mContext)
                    val repository = BookRepository(db)
                    val viewModel = BookViewModel(repository)

                    //Navigation
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen"){

                        composable("MainScreen"){
                            MainScreen(viewModel = viewModel, navController = navController)
                        }

                        composable("UpdateScreen/{bookId}"){
                            UpdateScreen(viewModel = viewModel, bookId = it.arguments?.getString("bookId"))
                        }

                    }

                    //MainScreen(viewModel, navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: BookViewModel, navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 22.dp, start = 6.dp, end = 6.dp)) {

        var inputText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = inputText,
            onValueChange = { newText -> inputText = newText },
            label = { Text(text = "Book Name", fontSize = 22.sp) },
            placeholder = { Text(text = "Enter Your Book Name") })

        Button(onClick = {
            viewModel.addBook(BookEntity(0, inputText))
        }) {
            Text(text = "Add Book")
        }

        //The Books List
        BookList(viewModel = viewModel, navController)

    }
}

@Composable
fun BookCard(viewModel: BookViewModel, books: BookEntity, navController: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row {
            Text(
                text = "" + books.id, fontSize = 24.sp,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )

            Text(text = books.title, fontSize = 24.sp)

            IconButton(onClick = {
                viewModel.delete(bookEntity = books)
            }) {
                Image(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete"
                )
            }

            IconButton(onClick = {
                navController.navigate("UpdateScreen/${books.id}")
            }) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit")
            }
        }

    }
}

@Composable
fun BookList(viewModel: BookViewModel, navController: NavHostController) {

    val books by viewModel.allBooks.collectAsState(initial = emptyList())

    LazyColumn {
        items(books) { item ->
            BookCard(viewModel = viewModel, books = item, navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppTheme {

    }
}