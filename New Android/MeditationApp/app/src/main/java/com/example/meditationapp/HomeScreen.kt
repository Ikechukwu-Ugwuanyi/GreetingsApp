package com.example.meditationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.DarkerButtonBlue
import com.example.meditationapp.ui.theme.DeepBlue
import com.example.meditationapp.ui.theme.LightRed
import com.example.meditationapp.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(feelings = listOf("Insonia", "Depression", "Sweet Sleep"))
            CurrentMeditation()
        }

    }

}

@Composable
fun GreetingSection(
    name: String = "Ikechukwu"
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning $name",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Good morning wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Icon(
            painterResource(
                id = R.drawable.ic_search
            ),
            contentDescription = "Search",
            Modifier.size(24.dp),
            tint = Color.White
        )
    }

}

@Composable
fun ChipSection(
    feelings: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(feelings.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .padding(15.dp)
            ) {
                Text(
                    text = feelings[it],
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(15.dp)
            .background(LightRed)
            .padding(vertical = 20.dp, horizontal = 25.dp)
            .fillMaxWidth()
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Meditation . 3 -10 Minutes",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .size(40.dp)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play Button",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
            )
        }


    }
}

@Composable
fun FeaturedSection(feature: List<Feature>) {
    
}