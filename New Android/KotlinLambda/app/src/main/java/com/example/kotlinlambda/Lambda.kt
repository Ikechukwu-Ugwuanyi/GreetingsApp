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

    //V.I Note
    //If the method body has only one statement, we can omit the return keyword and the braces

    val omit = fun(a: Int, b: Int): Int = a + b
    println(omit(99, 1))

    //Types of Anonymous Functions

    //With Parameters and Return value
    val multiply = fun(a: Int, b: Int): Int { return a * b }
    println(multiply(5, 5))

    //With Parameters and No Return Value
    val multiply2 = fun(a: Int, b: Int): Unit { println(a * b) }
    multiply2.invoke(6, 6)

    //No parameter but a return value
    val msg = fun(): String { return "I am with you for real" }
    println(msg())

    //No parameters and No Return value
    val multiply3 = fun(): Unit { println("I have no parameters and return value") }
    multiply3.invoke()

}