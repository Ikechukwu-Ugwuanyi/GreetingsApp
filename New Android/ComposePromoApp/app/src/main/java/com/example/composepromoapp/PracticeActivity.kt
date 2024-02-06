package com.example.composepromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composepromoapp.ui.theme.ComposePromoAppTheme

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePromoAppTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}
