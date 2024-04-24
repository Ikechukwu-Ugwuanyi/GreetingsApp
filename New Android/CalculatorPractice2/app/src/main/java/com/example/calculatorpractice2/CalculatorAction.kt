package com.example.calculatorpractice2

sealed class CalculatorAction {
    data class CalculatorNumber(val number: Int): CalculatorAction()
    object Delete : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal : CalculatorAction()
    object Clear : CalculatorAction()
    data class Operation(var operation: CalculatorOperation) : CalculatorAction()
}