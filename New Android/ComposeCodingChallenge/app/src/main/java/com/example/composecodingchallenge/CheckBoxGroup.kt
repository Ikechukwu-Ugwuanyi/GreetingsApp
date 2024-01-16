package com.example.composecodingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class CheckBoxGroup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckGroup()
                }
            }
        }
    }
}

@Composable
fun CheckGroup(){

    var foods : List<String> = listOf("Rice", "Beans", "Yam")
    var ctx = LocalContext.current.applicationContext

    Column(verticalArrangement = Arrangement.Center) {

        foods.forEach { check ->
            var checkedState by remember {
                mutableStateOf(false)
            }

            Row() {
                Checkbox(checked = checkedState,
                    onCheckedChange = { newCheck ->
                        checkedState = newCheck
                        Toast.makeText(ctx, "You clicked $check $checkedState", Toast.LENGTH_LONG).show()
                    })
                Text(text = check)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    ComposeCodingChallengeTheme {
        CheckGroup()
    }
}