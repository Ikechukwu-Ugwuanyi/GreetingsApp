package com.example.kotlinlambda

fun main(){


    //LAMBDA NOTES: There are two cases where parenthesis can be omitted from Lambdas.
    // Case 1: If the lambda is the only argument, you can omit the parenthesis
    //val add = {a:Int, b:Int -> a + b}
    hof{a:Int, b:Int -> a + b}

    //Case 2: If the lambda is the last argument
    hof2("Ikechukwu") { c: Int, b: Int -> c + b }

    hof3 {
        println("Hi $it")
    }

    val numbers = listOf(9,2,3,8,2,1,0,7,5)

    println(numbers.filter { numbers -> numbers > 5 })

    println(numbers.filter {
        it > 5
    })
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

fun hof3(name : (String) -> Unit){
    name("John")
}