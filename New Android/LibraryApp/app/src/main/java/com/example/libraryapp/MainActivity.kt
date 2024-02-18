package com.example.libraryapp

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
import com.example.libraryapp.ui.theme.LibraryAppTheme

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
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var inputText by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = inputText,
            onValueChange = { newText -> inputText = newText },
            label = { Text(text = "Book Name") },
            placeholder = { Text(text = "Enter Your Book Name") })

        Button(onClick = { }) {
            Text(text = "Add Book")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppTheme {

    }
}