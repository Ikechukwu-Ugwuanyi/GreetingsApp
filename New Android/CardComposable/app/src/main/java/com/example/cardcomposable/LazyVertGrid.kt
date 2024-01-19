package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardcomposable.ui.theme.CardComposableTheme

class LazyVertGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OSNames(osNames)
                }
            }
        }
    }
}

var osNames = listOf("Windows", "Apple", "Linux", "Ubuntu", "Android", "MacOs")


@Composable
fun OSNames(osNames: List<String>) {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
                items(osNames.size){
                        index -> Card(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(Color.Red)) {

                    Text(text = osNames[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                }
            } )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
            content = {
                items(osNames.size){
                        index -> Card(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(Color.Blue)) {

                    Text(text = osNames[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                }
            } )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    CardComposableTheme {
        //Greeting2()
    }
}