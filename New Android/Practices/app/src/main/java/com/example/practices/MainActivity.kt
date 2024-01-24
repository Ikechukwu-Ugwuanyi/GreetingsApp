package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.ui.theme.PracticesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayCards()
                }
            }
        }
    }
}

@Composable
fun DisplayCards() {

    val cardList = listOf(CardInfo("Ikechukwu Ugwuanyi",
        "6567 8764 0897 6789",
        R.drawable.visa,
        R.drawable.background_1),
        CardInfo("Eze Gift",
            "6789 9005 4567 5456",
            R.drawable.master_card,
            R.drawable.background_2),
        CardInfo("Amadi Kelechi",
            "3457 7890 7554 3456",
            R.drawable.visa,
            R.drawable.background_3),
        CardInfo("kenechukwu Donald",
            "7789 3456 3557 6789",
            R.drawable.master_card,
            R.drawable.background_4))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)){

        items(cardList){
            cardList -> CreditCard(cardInfo = cardList)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticesTheme {

    }
}