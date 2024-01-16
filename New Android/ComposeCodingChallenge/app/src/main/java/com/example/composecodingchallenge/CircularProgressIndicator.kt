package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class CircularProgressIndicator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting10()
                }
            }
        }
    }
}

@Composable
fun Greeting10() {
   Column {
       //Indeterminate Indicator -> runs forever
       CircularProgressIndicator(
           Modifier.width(30.dp),
           color = Color.Green,
           strokeWidth = 10.dp
       )

       //Determinate
       CircularProgressIndicator(
           progress = 0.6f,
           Modifier.width(60.dp),
           Color.Red,
           strokeWidth = 10.dp
       )

   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    ComposeCodingChallengeTheme {
        Greeting10()
    }
}