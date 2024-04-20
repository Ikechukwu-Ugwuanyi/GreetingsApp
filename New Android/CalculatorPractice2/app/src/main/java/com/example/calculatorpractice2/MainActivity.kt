package com.example.calculatorpractice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorpractice2.ui.theme.CalculatorPractice2Theme
import com.example.calculatorpractice2.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorPractice2Theme {
                // A surface container using the 'background' color from the theme
                val viewModel = viewModel<CalculatorViewModel>()
                val buttonSpacing = 8.dp
                val state = viewModel.state
                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .background(MediumGray)
                )
            }
        }
    }
}

