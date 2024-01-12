package com.example.newcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newcompose.ui.theme.NewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                   Column(){
                       Greeting("Android")
                       DisplayOurText()
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Good Morning",
        modifier = modifier
    )
}

@Composable
fun DisplayOurText(){
    SelectionContainer {
        Column {
            Text(text = "Welcome to NewCompose \n Welcome to NewCompose",
                color = Color.Blue,
                fontSize = 30.sp,
                maxLines = 1,
                overflow           = TextOverflow.Ellipsis,

                style = TextStyle(textDecoration = TextDecoration.LineThrough,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 30.sp,
                    letterSpacing = 5.sp,
                    fontFamily = FontFamily.Cursive,
                )
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewComposeTheme {
        Greeting("Android")
        DisplayOurText()
    }
}