package com.example.kotlinlambda

fun main(){

    //1. Lambda with parameters and return value
    val add1 : (Int, Int) -> Int =  {a:Int, b:Int -> a + b}
    println(add1(20,30))

    //2. Lambda with parameters and no return value
    val add2 : (Int, Int) -> Unit = {a,b -> println(a+b) }
    add2(20,50)

    //3. No parameters but with return value
    val add3 : () -> String = { "This is a string" }
    println(add3())

    //4. No parameters and no return values
    val add4 : () -> Unit = { println("Welcome again") }
    add4.invoke()

    //Direct use of lambda expression, with no variable
    println({a:Int, b:Int -> a * b}(4,5))

    //ANONYMOUS FUNCTIONS
    val a = fun(c:Int, d:Int) :Int  { return 60 + 30}
}