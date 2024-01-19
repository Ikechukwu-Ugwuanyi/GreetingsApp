package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cardcomposable.ui.theme.CardComposableTheme

class IntoToLists : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PopulateItems(osList)
                }
            }
        }
    }
}



var osList = listOf("Windows", "Linux", "IOS", "Apple")

@Composable
fun PopulateItems(osList: List<String>) {
    Column {
        osList.forEach {
            RowItem(osName = it)
        }
    }
}

@Composable
fun RowItem(osName: String) {
    Row {
        Text(text = osName, fontSize = 20.sp, color = Color.Magenta)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CardComposableTheme {
        PopulateItems(osList)
    }
}