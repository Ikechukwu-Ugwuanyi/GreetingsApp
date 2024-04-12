package com.example.calculatorpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {

    }

//    private fun enterDecimal() {
//        if (state.operation == null && !state.number1.contains(".")
//            && state.number1.isNotBlank()) {
//            state = state.copy(
//
//            )
//        }
//    }

    private fun performCalculation() {

    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(

            )
        }

    }

    private fun enterNumber(number: Int) {

    }


}