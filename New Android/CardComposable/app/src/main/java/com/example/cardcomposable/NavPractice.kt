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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cardcomposable.ui.theme.CardComposableTheme

class NavPractice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintCompose()
                    //DisplayNav2()

                }
            }
        }
    }
}

@Composable
fun ConstraintCompose(){
    ConstraintLayout {
        val(yellowBox, redBox,greenBox, blackBox, magentaBox, cyanBox, darkGrayBox) = createRefs()

        //Guide lines
        val guideline = createGuidelineFromBottom(0.5f)

        Box(modifier = Modifier.size(50.dp).background(Color.Yellow)
            .constrainAs(yellowBox){
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                //width = Dimension.fillToConstraints
                //height = Dimension.value(100.dp)
                //width = Dimension.matchParent
            })

        Box(modifier = Modifier.size(50.dp).background(Color.Yellow)
            .constrainAs(redBox){
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                //width = Dimension.fillToConstraints
                //height = Dimension.value(100.dp)
                //width = Dimension.matchParent
            })

        Box(modifier = Modifier.size(50.dp).background(Color.Yellow)
            .constrainAs(greenBox){
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                //width = Dimension.fillToConstraints
                //height = Dimension.value(100.dp)
                //width = Dimension.matchParent
            })

        createHorizontalChain(yellowBox, redBox, greenBox, chainStyle = ChainStyle.Packed)

    }
}
//
//@Composable
//fun DisplayNav2(){
//
//    val navController = rememberNavController()
//
//    NavHost(navController = navController,
//        startDestination = Dest.FirstShow.toString()){
//
//        composable(route = Dest.FirstShow.toString()){
//            Screen1(navController = navController)
//        }
//
//        composable(route = Dest.SecondShow.toString()+"/{user}"){
//            val arg = it.arguments?.getString("user")
//            Screen2(arg, navController = navController)
//        }
//
//    }
//
//}
//
//@Composable
//fun Screen1(navController: NavController){
//
//    Column(modifier = Modifier
//                .padding(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        var user by remember{
//            mutableStateOf("")
//        }
//        Text(text = "Welcome to screen one. \n Please enter your name.")
//        TextField(value = user, onValueChange = { username ->
//            user = username
//        })
//
//        Button(onClick = { navController.navigate(Dest.SecondShow.toString()+"/$user") }) {
//            Text(text = "Go to second screen")
//        }
//    }
//
//}
//
//
//@Composable
//fun Screen2(arg:String?, navController: NavController){
//
//    Column(modifier = Modifier
//        .padding(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        Text(text = "Hello $arg, welcome to screen two")
//        Button(onClick = { navController.navigate(Dest.FirstShow.toString()) }) {
//            Text(text = "Go to first screen")
//        }
//    }
//
//}