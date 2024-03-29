package com.example.cardcomposable

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

@Composable
fun CreditCard(cardInfo: CardInfo) {


    Card(
        modifier = Modifier.height(200.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box() {
            Image(
                painter = painterResource(cardInfo.backgroundImage),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = cardInfo.providerImage),
                    contentDescription = "Provider Logo",
                    modifier = Modifier
                        .width(86.dp)
                        .align(Alignment.TopStart)
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {

                    Text(
                        text = cardInfo.cardHolder,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.2.sp
                    )
                    Text(
                        text = cardInfo.cardNumber,
                        fontSize = 16.sp,
                        color = Color.White,
                        letterSpacing = 1.1.sp
                    )
                }
            }


        }

    }

}

@Composable
@Preview(showBackground = true)
fun CreditCardPreview() {
    val cardDemo = CardInfo(
        "1234 5678 1235 0987",
        "IKECHUKWU UGWUANYI",
        R.drawable.background_1,
        R.drawable.master_card
    )

    CreditCard(cardDemo)
}

