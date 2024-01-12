package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class BoxLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting5()
                }
            }
        }
    }
}

@Composable
fun Greeting5() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Hello Jack")

        Box(
            Modifier.align(Alignment.TopStart)
                .fillMaxHeight().width(50.dp)
                .background(Color.Cyan)
        )

        Text(text = "Hello Jude", Modifier.align(Alignment.CenterStart))
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    ComposeCodingChallengeTheme {
        Greeting5()
    }
}