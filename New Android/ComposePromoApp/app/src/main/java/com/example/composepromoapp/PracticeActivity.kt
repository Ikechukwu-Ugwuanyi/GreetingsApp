package com.example.composepromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

//Home Screen
@Composable
fun HomeScreen2(onAboutClick: () -> Unit, onDetailsClick: (title: String) -> Unit) {

    Scaffold { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                HomeAppBar(onAboutClick)
            }

            item {
                Spacer(modifier = Modifier.width(20.dp))
            }

            items(allCourses) { item ->
                CourseCard(
                    item,
                    onClick = { onDetailsClick(item.title) })
            }
        }
    }

}
