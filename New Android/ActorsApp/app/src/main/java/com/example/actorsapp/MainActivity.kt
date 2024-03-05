package com.example.actorsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actorsapp.retrofit.Characters
import com.example.actorsapp.ui.theme.ActorsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActorsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MainScreen()

                }
            }
        }
    }
}

@Composable
fun MainScreen() {

}

@Composable
fun ActorsList(characterList: List<Characters>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)) {
        items(items = characterList){
            item -> CardItem(characterList = item)
        }
    }

}

@Composable
fun CardItem(characterList: Characters){
    Column {

        Text(text = characterList.actor, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActorsAppTheme {

    }
}