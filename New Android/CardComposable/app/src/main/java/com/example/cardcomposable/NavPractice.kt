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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardcomposable.ui.theme.CardComposableTheme

class NavPractice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavDisplay()
                }
            }
        }
    }
}

@Composable
fun NavDisplay() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "First Screen"
    ) {

        composable(route = "First Screen") {
            FirstScreen2(navController)
        }

        composable(route = "Second Screen" + "/{username}") {
            val user = it.arguments?.getString("username")
            SecondScreen2(user, navController)

        }

    }

}


@Composable
fun FirstScreen2(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var username by remember {
            mutableStateOf("")
        }

        Text(text = "Welcome to First Screen. \n Please, enter your name")

        TextField(value = username, onValueChange = { newname ->
            username = newname
        })

        Button(onClick = { navController.navigate("Second Screen" + "/$username") }) {
            Text(text = "Go to Second Screen")
        }
    }
}


@Composable
fun SecondScreen2(user: String?, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hi $user, Welcome to Second Screen")
        Button(onClick = { navController.navigate("First Screen") }) {
            Text(text = "Go to First Screen")
        }
    }
}