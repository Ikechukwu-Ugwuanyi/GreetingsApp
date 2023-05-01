package com.example.myapplication

abstract class Person3 {
    var age : Int = 30

    fun displayAge() {
        println("My age is: $age")
    }

    abstract fun displayGreetings()

}