package com.example.morecomposepractice

var string = ""
    set(value){
        field = "Hello ${value.trim()}"
    }

fun main(){
    string = "Jack     "
    println(string)

}