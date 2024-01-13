package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class ButtonComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting6()
                }
            }
        }
    }
}

@Composable
fun Greeting6() {
    val context = LocalContext.current.applicationContext
    Column {
        Button(onClick = {
            Toast.makeText(context,
                "You clicked a button",
                Toast.LENGTH_LONG).show()},
            shape = RoundedCornerShape(size = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            ),
            modifier = Modifier
                .width(width = 200.dp)
                .height(height = 50.dp)


        )
        {
            Text(text = "Click Me")
        }

        Button(onClick = {
            Toast.makeText(context, "You Clicked a button", Toast.LENGTH_LONG).show()
        },
            ) {
            Text(text = "Another Button")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    ComposeCodingChallengeTheme {
        Greeting6()
    }
}