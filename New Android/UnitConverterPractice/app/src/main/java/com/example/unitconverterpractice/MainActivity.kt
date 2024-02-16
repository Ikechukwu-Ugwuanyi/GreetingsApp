package com.example.unitconverterpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverterpractice.ui.theme.UnitConverterPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val myViewModel: MyViewModel = viewModel()
                    Screen(myViewModel)
                }
            }
        }
    }
}

@Composable
fun Screen(myViewModel: MyViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var enteredValue by remember{
            mutableStateOf("")
        }

        Text(text = "Unit Converter App",
            fontWeight = FontWeight.Bold)

        OutlinedTextField(value = enteredValue,
            onValueChange = { newValue ->
            enteredValue = newValue
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            maxLines = 1
            )

        Button(onClick = {
            myViewModel.convertTemp(enteredValue)
        }) {
            Text(text = "Convert")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}