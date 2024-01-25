package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.ui.theme.PracticesTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun MyRadioGroup() {
    val radioOptions = listOf("Option1", "Option2", "Option3")
    val (selectedOption, onOptionsSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row (Modifier
                .fillMaxWidth()
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionsSelected(text) }
                )
                .padding(horizontal = 16.dp)){

                RadioButton(
                    selected = (selectedOption == text),
                    onClick = null)

                Text(
                    text = text,
                    Modifier.padding(start = 16.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PracticesTheme {

    }
}