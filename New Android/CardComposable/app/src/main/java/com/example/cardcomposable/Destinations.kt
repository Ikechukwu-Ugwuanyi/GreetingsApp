package com.example.cardcomposable

sealed class Destinations(val route : String) {
    data object FirstScreen: Destinations("First Screen")
    data object SecondScreen: Destinations("Second Screen")

}