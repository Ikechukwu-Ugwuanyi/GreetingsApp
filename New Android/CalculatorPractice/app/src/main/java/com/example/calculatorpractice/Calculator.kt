package com.example.calculatorpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    modifier: Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: CalculatorAction
) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Column(modifier) {
            Text(text = state.number1 + (state.operation) + state.number2,
                textAlign = TextAlign.End,
                fontSize = 80.sp,
                maxLines = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                letterSpacing = ((-2).sp),
                lineHeight = 60.sp
                )

            Row {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f)
                        .clickable { onAction(CalculatorAction.Clear) },
                    onClick = {onAction(CalculatorAction.Clear)}) {

                }
            }
        }
    }

}