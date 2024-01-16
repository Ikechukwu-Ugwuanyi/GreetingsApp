package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class RadioButtonComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting8()
                    RadioGroup()
                }
            }
        }
    }
}

@Composable
fun Greeting8() {
    var context = LocalContext.current
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        RadioButton(selected = true, onClick = {
            Toast.makeText(context, "You selected an option", Toast.LENGTH_LONG).show()
        })
        Text(text = "Pizza")
    }
}

@Composable
fun RadioGroup(){
    var ctx = LocalContext.current

    val radioOptions = listOf("Camry", "BMW", "Toyota")

    var (selectedItem, onOptionsSelected) = remember {
        mutableStateOf(radioOptions[0])
    }

    Column(modifier = Modifier.selectableGroup()) {

        radioOptions.forEach { label ->
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .selectable(
                    selected = (selectedItem == label),
                    onClick = { onOptionsSelected(label) },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp)){
                RadioButton(modifier = Modifier.padding(end = 16.dp),
                    onClick = { onOptionsSelected(label) },
                    selected = (selectedItem == label))
                Text(text = label)

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    ComposeCodingChallengeTheme {
        Greeting8()
    }
}