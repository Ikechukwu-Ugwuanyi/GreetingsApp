package com.example.calculatorpractice3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.example.calculatorpractice3.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {

    Box(modifier) {
        Column(
            modifier.align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontSize = 80.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                maxLines = 2,
                color = Color.White,
                letterSpacing = (-2.sp),
                lineHeight = 80.sp,
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(symbol = "AC",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(Color.LightGray),
                    onClick = { onAction(CalculatorAction.Clear) })
                CalculatorButton(symbol = "Del",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(Color.LightGray),
                    onClick = { onAction(CalculatorAction.Delete) })
                CalculatorButton(symbol = "/",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(Orange),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) })
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(symbol = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(7)) })

                CalculatorButton(symbol = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(8)) })
                CalculatorButton(symbol = "9",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(9)) })
                CalculatorButton(symbol = "*",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })

            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(symbol = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.LightGray),
                    onClick = { onAction(CalculatorAction.Number(4)) })
                CalculatorButton(symbol = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.LightGray),
                    onClick = { onAction(CalculatorAction.Number(5)) })
                CalculatorButton(symbol = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.LightGray),
                    onClick = { onAction(CalculatorAction.Number(6)) })
                CalculatorButton(symbol = "-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) })
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(symbol = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(1)) })
                CalculatorButton(symbol = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(2)) })
                CalculatorButton(symbol = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(3)) })
                CalculatorButton(symbol = "+",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) })
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(symbol = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Number(0)) })
                CalculatorButton(symbol = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Color.DarkGray),
                    onClick = { onAction(CalculatorAction.Decimal) })

                CalculatorButton(symbol = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
                    onClick = { onAction(CalculatorAction.Calculate) })
            }
        }

    }

}