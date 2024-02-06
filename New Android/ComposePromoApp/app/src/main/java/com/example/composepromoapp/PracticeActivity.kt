package com.example.composepromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                HomeAppBar2(onAboutClick)
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

@Composable
fun HomeAppBar2(onAboutClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 10.dp)) {

        Text(text = "MyUdemy Course",
            style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.weight(1f))

        TextButton(onClick = {onAboutClick }) {
            Text(text = "About",
                fontSize = 20.sp)

        }
    }
}
