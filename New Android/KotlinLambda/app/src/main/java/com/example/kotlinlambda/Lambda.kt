package com.example.kotlinlambda

fun main() {
    val welcome = { println("Welcome to our course") }
    welcome.invoke()

    //1. Lambda with parameters and return value
    val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(add(3, 5))

    //2. Lambda with parameters and no return value
    val add2: (Int, Int) -> Unit = { a, b -> println(a + b) }
    add2.invoke(8, 9)

    //3. No parameters but with return value
    val add3: () -> String = { "I am here" }
    println(add3())

    //4. No parameters and no return values
    val add4: () -> Unit = { println("Welcome again, here we go!") }
    add4.invoke()

    //Direct use of lambda expression, with no variable
    println({ a: Int, b: Int -> a + b }(4, 9))

    //ANONYMOUS FUNCTIONS
    val anon = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(anon.invoke(9, 90))

}