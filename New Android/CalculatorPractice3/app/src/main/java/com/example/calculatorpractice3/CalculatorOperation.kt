package com.example.calculatorpractice3

sealed class CalculatorOperation(val symbol : String) {
    object Multiply: CalculatorOperation("*")
    object Divide: CalculatorOperation("/")
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
}