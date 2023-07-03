package com.example.dependencvyinjectionapp

class Car {

    private val engine = Engine()

    fun start(){
        engine.startEngine()
    }
}