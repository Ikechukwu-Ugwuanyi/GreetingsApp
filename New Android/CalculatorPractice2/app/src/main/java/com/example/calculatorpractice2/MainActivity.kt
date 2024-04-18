package com.example.calculatorpractice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculatorpractice2.ui.theme.CalculatorPractice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorPractice2Theme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

