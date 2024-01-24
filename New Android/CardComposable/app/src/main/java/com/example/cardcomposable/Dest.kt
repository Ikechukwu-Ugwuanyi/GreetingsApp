package com.example.cardcomposable

sealed class Dest(val route: String) {
    object FirstShow:Dest("First Screen")
    object SecondShow:Dest("Second Screen")
}