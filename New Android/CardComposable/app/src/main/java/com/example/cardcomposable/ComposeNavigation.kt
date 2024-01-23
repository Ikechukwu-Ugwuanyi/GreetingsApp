package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardcomposable.ui.theme.CardComposableTheme

class ComposeNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayNav()
                }
            }
        }
    }
}

@Composable
fun DisplayNav(){

    //NavController
    val navController = rememberNavController()

    //NavHost
    NavHost(navController = navController,
            startDestination = "First Screen") {

        composable(route = "First Screen"){
            FirstScreen()
        }

        composable(route = "Second Screen"){
            SecondScreen()
        }

    }
}

@Composable
fun FirstScreen(){
    Button(onClick = {  }) {
        Text(text = "Welcome to First Screen")
    }
}


@Composable
fun SecondScreen(){
    Button(onClick = {  }) {
        Text(text = "Welcome to Second Screen")
    }
}
