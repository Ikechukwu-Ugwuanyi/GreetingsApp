package com.example.practices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreditCard(cardInfo: CardInfo){

    Card(modifier = Modifier
        .size(200.dp)
        .padding(8.dp)
        .fillMaxSize(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {

        Image(
            painter = painterResource(cardInfo.backgroundImage),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize())

        Box(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(cardInfo.providerImage),
                contentDescription = "Provider Image",
                Modifier
                    .size(16.dp)
                    .align(Alignment.TopStart)
            )

            Column(Modifier.align(Alignment.BottomStart)) {
                Text(text = cardInfo.cardHolder,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    letterSpacing = 1.1.sp)

                Text(text = cardInfo.cardHolder,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    letterSpacing = 1.1.sp)
            }

        }

    }
}