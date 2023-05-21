package com.example.kotlinexercise

import java.util.Scanner

fun main() {

//    var char: String = "This is a set of characters to be reversed"
//    println(char.reversed())

    //To be entered by User
//    var s1 = Scanner(System. `in`)
//    println("Enter a string \n")
//    var charReverse = s1.nextLine().reversed()
//    println("The reverse of your entry: is $charReverse")

    //PROGRAM TO MULTIPLY CORRESPONDING ELEMENTS OF 2 ARRAYS OF INTEGERS
    var arr1 = arrayOf(-2, 4, 5, -1, 2)
    var arr2 = arrayOf(-1, 2, 5, -1, 4)
    var result = " "

    for (i in arr1.withIndex()) {
        result += (arr1[i.index] * arr2[i.index])
        result += " "
    }

    print(result)


}