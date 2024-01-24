package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
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
                    DisplayNav2()

                }
            }
        }
    }
}

@Composable
fun DisplayNav2(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Dest.FirstShow.toString()){

        composable(route = Dest.FirstShow.toString()){
            Screen1(navController = navController)
        }

        composable(route = Dest.SecondShow.toString()+"/{user}"){
            val arg = it.arguments?.getString("user")
            Screen2(arg, navController = navController)
        }

    }

}

@Composable
fun Screen1(navController: NavController){

    Column(modifier = Modifier
                .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var user by remember{
            mutableStateOf("")
        }
        Text(text = "Welcome to screen one. \n Please enter your name.")
        TextField(value = user, onValueChange = { username ->
            user = username
        })

        Button(onClick = { navController.navigate(Dest.SecondShow.toString()+"/$user") }) {
            Text(text = "Go to second screen")
        }
    }

}


@Composable
fun Screen2(arg:String?, navController: NavController){

    Column(modifier = Modifier
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Hello $arg, welcome to screen two")
        Button(onClick = { navController.navigate(Dest.FirstShow.toString()) }) {
            Text(text = "Go to first screen")
        }
    }

}