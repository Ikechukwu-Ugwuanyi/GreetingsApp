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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
        val(yellowBox, redBox,greenBox, blackBox, magentaBox, cyanBox, darkGrayBox) = createRefs()

        //Guide lines
        val guideline = createGuidelineFromBottom(0.5f)

        Box(modifier = Modifier.size(50.dp).background(Color.Yellow)
            .constrainAs(yellowBox){
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                //height = Dimension.value(100.dp)
                //width = Dimension.matchParent
            })

        Box(modifier = Modifier.size(50.dp).background(Color.Red).constrainAs(redBox){
            top.linkTo(yellowBox.bottom)
            end.linkTo(yellowBox.end)
        })

        Box(modifier = Modifier.size(50.dp).background(Color.Green).constrainAs(greenBox){
            top.linkTo(redBox.bottom)
            end.linkTo(redBox.end)
        })

        Box(modifier = Modifier.size(50.dp).background(Color.Black).constrainAs(blackBox){
            top.linkTo(greenBox.bottom)
        })

        Box(modifier = Modifier.size(50.dp).background(Color.Magenta).constrainAs(magentaBox){
            top.linkTo(greenBox.bottom)
        })

        Box(modifier = Modifier.size(50.dp)
            .background(Color.Cyan)
            .constrainAs(cyanBox){
            bottom.linkTo(guideline)
        })

        Box(modifier = Modifier.size(50.dp)
            .background(Color.DarkGray)
            .constrainAs(darkGrayBox){
                end.linkTo(parent.end)
                bottom.linkTo(guideline)

        })






        createHorizontalChain(blackBox, magentaBox, chainStyle = ChainStyle.Packed)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    CardComposableTheme {
        ConstraintScreen()
    }
}