package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class CheckBoxComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckBox()
                }
            }
        }
    }
}

@Composable
fun CheckBox() {

    var ctx = LocalContext.current.applicationContext

    var checkState by remember {
        mutableStateOf(false)
    }
    Row(modifier = Modifier.padding(15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checkState,
            onCheckedChange = { newCheck ->
                checkState = newCheck
                Toast.makeText(ctx, "You clicked $checkState", Toast.LENGTH_LONG).show()
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red
            )
        )

        Text(text = "Pizza")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
    ComposeCodingChallengeTheme {
        CheckBox()
    }
}