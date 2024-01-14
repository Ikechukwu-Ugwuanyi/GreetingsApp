package com.example.morecomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.morecomposepractice.ui.theme.MoreComposePracticeTheme

class TextFieldComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoreComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3()
                }
            }
        }
    }
}

@Composable
fun Greeting3() {

    //TextFields
    //OutlinedTextField
    //BasicTextField

    var enteredText by remember {
        mutableStateOf("")
    }

    var isUserBelow18 by remember {
        mutableStateOf(false
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(value = enteredText,
            onValueChange = {newValue -> enteredText = newValue},
            label = { Text(text = "Name")},
            placeholder = { Text(text = "Enter Your Name")},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email")},
            isError = isUserBelow18,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    isUserBelow18 = validateAge(inputText = enteredText)
                }
            )
            )
        if (isUserBelow18){
            Text(text = "You should be 18+",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.error)
        }

        
        

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MoreComposePracticeTheme {
        Greeting3()
    }
}

private fun validateAge(inputText:String): Boolean{
    return inputText.toInt() < 18
}