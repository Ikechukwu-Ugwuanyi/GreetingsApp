package com.example.myapplication

class Car() : Vehicle {
    override val speedValue: Int = 25
    override fun startEngine(): String {
        return "Starting the Engine"
    }

}