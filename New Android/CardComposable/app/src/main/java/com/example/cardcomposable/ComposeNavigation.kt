package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
            startDestination = Destinations.FirstScreen.toString()
    ) {

        composable(route = Destinations.FirstScreen.toString()){
            FirstScreen(navController)
        }

        composable(route = Destinations.SecondScreen.toString()){
            SecondScreen(navController)
        }

    }
}

@Composable
fun FirstScreen(navController: NavController){
   Column{
       Button(onClick = { navController.navigate(Destinations.SecondScreen.toString()) }) {
           Text(text = "Go to Second Screen")
       }
   }
}


@Composable
fun SecondScreen(navController: NavController){
    Column {
        Button(onClick = { navController.navigate(Destinations.FirstScreen.toString()) }) {
            Text(text = "Go to First Screen")
        }
    }
}
