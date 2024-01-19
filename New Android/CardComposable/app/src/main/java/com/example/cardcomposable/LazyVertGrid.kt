package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

var osNames = listOf("Windows", "Apple", "Linus", "Ubuntu")


@Composable
fun OSNames(osNames: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), 
        content = {
            items(osNames.size){
                index -> Card {
                Text(text = osNames[index])
            } 
            }
        } )   
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    CardComposableTheme {
        //Greeting2()
    }
}