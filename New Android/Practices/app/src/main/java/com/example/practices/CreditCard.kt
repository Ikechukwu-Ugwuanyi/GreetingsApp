package com.example.practices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practices.ui.theme.PracticesTheme

@Composable
fun CreditCard(cardInfo: CardInfo) {

    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {

        Box() {

            Image(
                painter = painterResource(id = cardInfo.backgroundImage),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Box(modifier = Modifier.padding(16.dp)
                .fillMaxSize()) {

                Image(
                    painter = painterResource(cardInfo.providerImage),
                    contentDescription = "Provider Image",
                    Modifier
                        .width(80.dp)
                        .align(Alignment.TopStart)
                )

                Column(Modifier.align(Alignment.BottomStart)) {
                    Text(
                        text = cardInfo.cardHolder,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White,
                        letterSpacing = 1.1.sp
                    )

                    Text(
                        text = cardInfo.cardNumber,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.White,
                        letterSpacing = 1.1.sp
                    )
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    PracticesTheme {
        val cardView = CardInfo(
            "Ikechukeu",
            "9576 57589 95785",
            R.drawable.background_1,
            R.drawable.master_card
        )

        CreditCard(cardView)
    }
}