package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class SwitchComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting9()
                }
            }
        }
    }
}

@Composable
fun Greeting9() {
    var switchOn by remember {
        mutableStateOf(false)
    }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Switch(checked = switchOn,
            onCheckedChange = {switchState ->
                switchOn = switchState
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Blue,
                checkedThumbColor = Color.Gray
            ),
            modifier = Modifier.padding(15.dp))
        Text(text = "Dark Mode")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    ComposeCodingChallengeTheme {
        Greeting9()
    }
}