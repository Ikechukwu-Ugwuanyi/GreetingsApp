package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class Fab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting13()
                }
            }
        }
    }
}

@Composable
fun Greeting13() {

    val ctx = LocalContext.current
    Box(Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            onClick = {
                Toast.makeText(ctx, "You Clicked Toast Message", Toast.LENGTH_SHORT).show()
            }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Fab")
        }

    }

    Box(Modifier.fillMaxWidth()) {
        ExtendedFloatingActionButton(
            onClick = {
                Toast.makeText(ctx, "You Clicked Toast Message", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(alignment = Alignment.BottomStart)
        ) {
            Text(text = "Search")
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview16() {
    ComposeCodingChallengeTheme {
        Greeting13()
    }
}