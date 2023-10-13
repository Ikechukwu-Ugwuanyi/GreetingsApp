package com.example.newdependencyinjection

class Car(private val engine: Engine) {
    //private val engine = Engine()

    fun start() {
        engine.startEngine()
    }
}