package com.example.calculatorpractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculatorpractice3.ui.theme.CalculatorPractice3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorPractice3Theme {
                // A surface container using the 'background' color from the theme


            }
        }
    }
}
