package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class ColumnsAndRows : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4()
                }
            }
        }
    }
}

@Composable
fun Greeting4() {
    Row(horizontalArrangement = Arrangement.Center) {
        Text(text = "Hello Jack")
        Text(text = "Hello Jane")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ComposeCodingChallengeTheme {
        Greeting4()
    }
}