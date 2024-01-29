package com.example.kotlinlambda

fun main(){

    //val add = {a:Int, b:Int -> a + b}
    hof{a:Int, b:Int -> a + b}

    hof2("Ikechukwu") { c: Int, b: Int -> c + b }
}

//Higher Order Function

fun hof(addition:(Int, Int) -> Int){
    val result = addition(6,10)
    println(result)
}

fun hof2(name: String, addition: (Int, Int) -> Int){
    val result = addition(20,8)
    println("Hello $name $result")
}