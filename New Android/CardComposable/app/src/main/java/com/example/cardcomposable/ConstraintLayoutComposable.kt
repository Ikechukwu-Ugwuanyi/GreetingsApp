package com.example.cardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cardcomposable.ui.theme.CardComposableTheme

class ConstraintLayoutComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintScreen()
                }
            }
        }
    }
}

@Composable
fun  ConstraintScreen(){
    ConstraintLayout {
        val(yellowBox, redBox,greenBox) = createRefs()

        Box(modifier = Modifier.size(50.dp).background(Color.Yellow)
            .constrainAs(yellowBox){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier.size(50.dp).background(Color.Red).constrainAs(redBox){
            top.linkTo(yellowBox.bottom)
            end.linkTo(yellowBox.end)
        })

        Box(modifier = Modifier.size(50.dp).background(Color.Green).constrainAs(greenBox){
            top.linkTo(redBox.bottom)
            end.linkTo(redBox.end)
        })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    CardComposableTheme {
        ConstraintScreen()
    }
}