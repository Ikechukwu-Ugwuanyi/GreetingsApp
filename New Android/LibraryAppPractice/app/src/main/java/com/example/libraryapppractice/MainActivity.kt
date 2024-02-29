package com.example.libraryapppractice

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapppractice.repository.BookRepository
import com.example.libraryapppractice.room.BooKEntity
import com.example.libraryapppractice.room.BookDB
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
                    val mContext = LocalContext.current
                    val db = BookDB.getInstance(mContext)
                    val repository = BookRepository(db)
                    val viewModel = BookViewModel(repository)


                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable("MainScreen") {
                            MainScreen(bookViewModel = viewModel, navController = navController)
                        }

                        composable("UpdateScreen/{bookId}") {
                            UpdateScreen(
                                bookViewModel = viewModel,
                                bookId = it.arguments?.getString("bookId")
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun MainScreen(bookViewModel: BookViewModel, navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {

        var inputText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = inputText,
            onValueChange = { newText -> inputText = newText },
            label = { Text(text = "Enter Book Name") },
            placeholder = { Text(text = "Enter Book Name") })

        Button(onClick = {
            val add = BooKEntity(0, inputText)
            bookViewModel.addBook(add)
        }) {
            Text(text = "Add Book to DB")
        }
        BookList(bookViewModel, navController)
    }

}

@Composable
fun BookCard(
    bookViewModel: BookViewModel,
    booK: BooKEntity,
    navController: NavHostController
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row {

            Text(
                text = booK.bookId.toString(),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                color = Color.Blue
            )

            Text(
                text = booK.bookTitle,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxSize(0.7f),
                color = Color.Black
            )

            Row(
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton(onClick = {
                    bookViewModel.deleteBook(booKEntity = booK)
                }) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Icon")
                }

                IconButton(onClick = {
                    navController.navigate("UpdateScreen/${booK.bookId}")
                }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Icon")
                }

            }
        }
    }
}


@Composable
fun BookList(bookViewModel: BookViewModel, navController: NavHostController) {

    val books by bookViewModel.getAllBooks.collectAsState(initial = emptyList())

    Column(Modifier.padding(16.dp)) {
        Text(text = "My Library", fontSize = 24.sp, color = Color.Red)

        LazyColumn {
            items(books) { item ->
                BookCard(bookViewModel = bookViewModel, booK = item, navController)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppPracticeTheme {

    }
}