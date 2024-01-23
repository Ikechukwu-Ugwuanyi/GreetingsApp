package com.example.cardcomposable

sealed class Destinations(val route : String) {
    object FirstScreen: Destinations("First Screen")
    object SecondScreen: Destinations("Second Screen")

}