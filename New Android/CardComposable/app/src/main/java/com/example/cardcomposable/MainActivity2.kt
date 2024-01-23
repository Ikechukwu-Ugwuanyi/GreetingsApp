package com.example.cardcomposable

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
import com.example.cardcomposable.ui.theme.CardComposableTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
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
    val cardList = listOf(CardInfo("EBUBECHI BLESSING",
        "2453 8906 4567 3456",
        R.drawable.master_card,
        R.drawable.background_1),

        CardInfo("NKECHI BLESSING",
            "97452 5678 9087 3457",
            R.drawable.visa,
            R.drawable.background_2),

        CardInfo("EBUKA CHINEDU",
            "6789 5689 0975 7765",
            R.drawable.master_card,
            R.drawable.background_3),

        CardInfo("CHINAZA PHILIP",
            "8890 2345 4322 7765",
            R.drawable.visa,
            R.drawable.background_4))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)){

        items(cardList){
                cardList -> CreditCard(cardInfo = cardList)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    CardComposableTheme {

    }
}