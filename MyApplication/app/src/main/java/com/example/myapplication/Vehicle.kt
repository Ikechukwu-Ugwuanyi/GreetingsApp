package com.example.myapplication

interface Vehicle {
    val speedValue: Int

    fun startEngine(): String
    fun accelerate() {
        println("Accelerating...")
    }
}