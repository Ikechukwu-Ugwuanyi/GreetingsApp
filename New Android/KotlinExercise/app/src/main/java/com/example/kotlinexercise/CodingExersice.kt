package com.example.kotlinexercise

import java.util.Scanner

fun main() {
    //Calculation of Division & Quotient of two numbers
//    var firstEntry = Scanner(System. `in`)
//
//    print("Please enter a number")
//    var x = firstEntry.nextInt()
//
//    print("Please enter second number")
//    var y = firstEntry.nextInt()
//
//
//    var result = x / y
//    var remainder = x % y
//
//    println("The result = $result and the remainder is $remainder")

    //Radius of a Circle
//    var s1 = Scanner(System. `in`)
//
//    print("Please enter a radius")
//    var radius = s1.nextInt()
//
//    var perimeter = 2 * 3.142 * radius
//    var area = 3.142 * (radius * radius)
//
//    println("The perimeter is $perimeter and the area is $area")

    //PROGRAM TO SWAP 2 VARIABLES
//    var s1 = Scanner(System. `in`)
//
//    print("Enter first variable")
//    var a = s1.nextInt()
//
//    print("Enter second variable")
//    var b = s1.nextInt()
//
//    var temp = a;
//    a = b
//    b = temp
//
//    var swapValue = print("The First value is $a and second value is $b")

    //PROGRAM TO CHECK THE LENGTH OF CHARACTERS
//    var s1 = Scanner(System. `in`)
//
//    println("Enter a word")
//    var word = s1.nextLine()
//
//
//    var wordLenght = word.length
//
//    print("The word $word has $wordLenght characters")

    //PROGRAM TO COUNT NUMBERS, SPACES, CHAR, AND LETTERS OF AN INPUT STRING
    print("Enter some characters")
    var s1 = Scanner(System.`in`)
    var text = s1.nextLine()

    count(text)
}

    fun count(text: String) {
        //We need to convert the strings(text) into Character arrays
        var ch = text.toCharArray()

        var letter = 0
        var space = 0
        var num = 0
        var others = 0

        //Looping through every character in ythe string
        for(c in ch.withIndex()) {
            if(Character.isLetter(c.value)) {
                letter++
            } else if (Character.isDigit(c.value)) {
                num++
            } else if (Character.isSpaceChar(c.value)) {
                space++
            } else {
                others++
            }
        }

        print("Letters: $letter \n Num: $num \n Spaces: $space \n Others: $others")
    }




