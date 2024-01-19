package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cardcomposable.ui.theme.CardComposableTheme

class LazyColumnComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PopulateItems2(osList2)
                }
            }
        }
    }
}

var osList2 = listOf("Windows", "Linux", "IOS", "Apple","Windows", "Linux", "IOS", "Apple",
    "Windows", "Linux", "IOS", "Apple","Windows", "Linux", "IOS", "Apple",
    "Windows", "Linux", "IOS", "Apple","Windows", "Linux", "IOS", "Apple",
    "Windows", "Linux", "IOS", "Apple","Windows", "Linux", "IOS", "Apple",)

@Composable
fun PopulateItems2(osList: List<String>) {
    LazyColumn(){
        item {
            Text(text = "item one")
        }
        items(10){index ->
            Text(text = "item $index")            
        }
        
        items(osList2){
            Text(text = "OS Name $it")
        }
    }
}

@Composable
fun RowItem2(osName: String) {
    Row {
        Text(text = osName, fontSize = 20.sp, color = Color.Black)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CardComposableTheme {
        PopulateItems2(osList2)
    }
}