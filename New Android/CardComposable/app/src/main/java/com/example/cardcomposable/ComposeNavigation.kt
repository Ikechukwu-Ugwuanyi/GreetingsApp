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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

        composable(route = Destinations.SecondScreen.toString()+"/{username}"){
            val user = it.arguments?.getString("username")
            SecondScreen(user, navController)
        }

    }
}

@Composable
fun FirstScreen(navController: NavController){
   Column{

       var username by remember{
           mutableStateOf("")
       }

       TextField(value = username,
           onValueChange = { newName ->
               username = newName
           })

       Button(onClick = { navController.navigate(Destinations.SecondScreen.toString()+"/$username") }) {
           Text(text = "Go to Second Screen")
       }
   }
}


@Composable
fun SecondScreen(user: String?, navController: NavController){
    Column {
        Text(text = "Welcome $user to Second screen")
        Button(onClick = { navController.popBackStack(Destinations.FirstScreen.toString(), inclusive = true) }) {
            Text(text = "Go to First Screen")
        }
    }
}
