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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapppractice3.repository.LibraryRepository
import com.example.libraryapppractice3.room.LibraryDatabase
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

                    val mContext = LocalContext.current
                    val db = LibraryDatabase.getInstance(mContext)
                    val repository = LibraryRepository(db)
                    val viewModel = LibraryViewModel(repository)

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen"){
                        composable("MainScreen"){
                            MainScreen(viewModel = viewModel, navController = navController)
                        }

                        composable("UpdateScreen/{bookId}"){
                            UpdateScreen(viewModel = viewModel, bookId = it.arguments?.getString("bookId"))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: LibraryViewModel, navController: NavHostController) {

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

        LibraryList(viewModel = viewModel, navController = navController)
    }



}

@Composable
fun LibraryCard(book: LibraryEntity, viewModel: LibraryViewModel, navController: NavHostController) {

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
                    navController.navigate("UpdateScreen/${book.bookId}")
                }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit Icon"
                    )
                }
            }

        }
    }

}

@Composable
fun LibraryList(viewModel: LibraryViewModel, navController: NavHostController){

    val books by viewModel.allBooks.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(8.dp)) {

        Text(text = "My Library Books")

        LazyColumn{
            items(books){
                item -> LibraryCard(book = item, viewModel = viewModel, navController = navController)
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