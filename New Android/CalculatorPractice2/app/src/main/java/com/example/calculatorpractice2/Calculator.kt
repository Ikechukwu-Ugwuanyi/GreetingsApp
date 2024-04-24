package com.example.calculatorpractice2

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
import com.example.calculatorpractice2.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
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
                lineHeight = 60.sp,
                letterSpacing = (-2).sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .weight(2f)
                        .aspectRatio(2f)
                        .background(Color.LightGray),
                    onclick = { onAction(CalculatorAction.Clear) })

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.LightGray),
                    onclick = { onAction(CalculatorAction.Delete) })

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.LightGray),
                    onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(7)) })

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(8)) })

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(9)) })

                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Orange),
                    onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(4)) })

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(5)) })

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(6)) })

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Orange),
                    onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(1)) })

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(2)) })

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.CalculatorNumber(3)) })

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Orange),
                    onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) })

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .weight(2f)
                        .aspectRatio(2f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.Clear) })

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.DarkGray),
                    onclick = { onAction(CalculatorAction.Decimal) })

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Orange),
                    onclick = { onAction(CalculatorAction.Calculate) })
            }
        }
    }

}