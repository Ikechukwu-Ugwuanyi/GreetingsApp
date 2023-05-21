package com.example.kotlincollections

fun main () {

    //ImmutableLists
    val list1 = listOf<Int>(1, 2, 3, 5)

    for(item in list1) {
        println(item)
    }

    //Mutable list
    var mutable = mutableListOf<String>("John", "Philip", "Henry")
    mutable[2] ="Rose"

    mutable.add("Peace")

    for(items in mutable) {
        println(items)
    }

    //Immutable Set
    var immutable = setOf(5,"Yes", 7,9,4,5,"Yes",7,7)
    for (item in immutable) {
        println(item)
    }

    //Mutable Set
    var mutableset = mutableSetOf<Int>(66,8,9,4,5,6,6)
    mutableset.add(50)
    mutableset.remove(4)
    for (item in mutableset) {
        println(item)
    }

    //Immutable maps
    var immMap = mapOf(1 to "Jesus", 4 to "Joseph", 6 to "Mary")
    for (key in immMap.keys){
        println(immMap[key])
    }

    //MutableMap
    var mutMap = mutableMapOf<Int, String>(1 to "James", 5 to "Philip", 3 to "John")
    mutMap.put(90 ,"Jude")

    for (key in mutMap.keys){
        println(mutMap[key])
    }


}