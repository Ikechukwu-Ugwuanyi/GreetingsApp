package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class ImageComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting7()
                }
            }
        }
    }
}

@Composable
fun Greeting7() {
    Image(painter = painterResource(id = R.drawable.tiger),
        contentDescription = "This is a tiger",
        modifier = Modifier
            .size(100.dp)
            .scale(0.6f)
            .aspectRatio(16f/9f)
            .clip(CircleShape)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                //edgeTreatment = BlurredEdgeTreatment.Unbounded
                edgeTreatment = BlurredEdgeTreatment(shape = RoundedCornerShape(percent = 5))
            )
            .border(width = 2.dp,
                color = androidx.compose.ui.graphics.Color.Green,
                    shape = CircleShape),
        contentScale = ContentScale.Crop
        )



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    ComposeCodingChallengeTheme {
        Greeting7()
    }
}