package com.example.morecomposepractice

var string = ""
    set(value){
        field = "Hello ${value.trim()}"
    }

private  var stringOne by TrimAppendDelegate()
private  var stringTwo by TrimAppendDelegate()

fun main(){
    stringOne = "Jack     "
    println(stringOne)
    stringTwo = "Jude                            "
    println(stringTwo)

}





















