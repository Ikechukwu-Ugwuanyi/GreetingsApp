package com.example.composeunitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.composeunitconverterapp.ui.theme.ComposeUnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()

                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Unit Converter App")

        OutlinedTextField(
            value = "",
            onValueChange = { enteredTemp ->
                newTemp = enteredTemp
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            label = { Text(text = "Enter Temperature") },
            singleLine = true
        )

        Button(onClick = { }) {
            Text(text = "Convert to Celsius")
        }

        Text(
            text = "The temperature in Degree Celsius is: $",
            fontSize = 30.sp
        )
    }
}


