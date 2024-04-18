package com.example.calculatorpractice2

data class CalculatorState (
    var number1: String = "",
    var number2: String = "",
    var operation:CalculatorOperation? = null
)