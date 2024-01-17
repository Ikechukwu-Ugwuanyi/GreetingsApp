package com.example.composecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecodingchallenge.ui.theme.ComposeCodingChallengeTheme

class BottomNav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomNavigation()
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation() {

    val bottomMenuList = prepareBottomMenu()

    val ctx = LocalContext.current

    var selecetedItem by remember {
        mutableStateOf("Home")
    }




}

fun prepareBottomMenu():List<BottomMenuItems>{

    val bottomMenuListItem = arrayListOf<BottomMenuItems>()

    bottomMenuListItem.add(BottomMenuItems("Home", Icons.Filled.Home))
    bottomMenuListItem.add(BottomMenuItems("Profile", Icons.Filled.AccountCircle))
    bottomMenuListItem.add(BottomMenuItems("Cart", Icons.Filled.ShoppingCart))
    bottomMenuListItem.add(BottomMenuItems("Settings", Icons.Filled.Settings))

    return bottomMenuListItem
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview15() {
    ComposeCodingChallengeTheme {
        MyBottomNavigation()
    }
}