package com.example.libraryapppractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
                inputText = newText },
            placeholder = { Text(text = "Enter Book Name")},
            label = { Text(text = "Book Name")})

        Button(onClick = {
            val add = LibraryEntity(0, inputText)
            viewModel.addBook(add)
        }) {
            Text(text = "Add Book")

        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppPractice3Theme {

    }
}