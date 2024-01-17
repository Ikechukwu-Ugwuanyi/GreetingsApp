package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class Scafolds : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting12()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Greeting12() {
    var ctx = LocalContext.current.applicationContext

    Box {
        TopAppBar(title = {
            Text(
                text = "Our Courses",
                color = Color.White
            )
        },
            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(
                        ctx,
                        "You clicked Navigation",
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "Menu Icon",

                        )

                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                Color.Red
            ),
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                }
            }

        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    ComposeCodingChallengeTheme {
        Greeting12()
    }
}