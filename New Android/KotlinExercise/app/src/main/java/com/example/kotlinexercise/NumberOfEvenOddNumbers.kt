package com.example.kotlinexercise

import java.util.Scanner

fun main() {
    //PROGRAM TO COUNT THE NUMBER OF EVEN AND ODD ELEMENTS IN A GIVEN ARRAY

//    var oddEven = arrayOf(2, 4, 5, 3, 6, 8, 9, 8)
//    var evenCount = 0
//    var oddCount = 0
//
//    for (i in oddEven) {
//        if (i % 2 == 0) {
//            evenCount++
//        } else {
//            oddCount++
//        }
//
//    }
//
//    println("The number of even numbers are: $evenCount \n The number of oddNumbers are: $oddCount")

    //PROGRAM THAT TAKES 3 NUMBERS FROM THE USER AND PRINTS THE GREATEST NUMBER AMONG THEM
    var s1 = Scanner(System. `in`)

    print("Enter the first number")
    var a = s1.nextInt()

    print("Enter the second number")
    var b = s1.nextInt()

    print("Enter the third number")
    var c = s1.nextInt()

    if (a > b) {
        if (a > c) {
            print("$a is the greatest")
        }
    }

    if (b > a) {
        if (b > c) {
            print("$b is the greatest")
        }
    }

    if (c > a) {
        if (c > b) {
            print("$c is the greatest")
        }
    }

}