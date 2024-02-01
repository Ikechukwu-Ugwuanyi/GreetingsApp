package com.example.composepromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction.Companion.Go
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepromoapp.ui.theme.ComposePromoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePromoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun HomeScreen(onAboutClick: () -> Unit, onDetailsClick: (title: String) -> Unit) {

    Scaffold { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                HomeAppBar(onAboutClick)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            items(allCourses) { item ->
                CourseCard(
                    item,
                    onclick = { onDetailsClick(item.title) })
            }
        }
    }
}

@Composable
private fun HomeAppBar(onAboutClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

        Text(
            text = "My Udemy Courses",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { onAboutClick }) {
            Text(
                text = "About",
                fontSize = 24.sp
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(item: Courses, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        onClick = onClick
    ) {

        Column() {
            Image(
                painterResource(
                    id = item.thumbnail
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = item.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.body,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }

    }
}

@Composable
fun AboutScreen(onNavigateUp: () -> Unit) {

    Scaffold { padding ->
        Column(Modifier.padding(padding)) {
            Appbar("About", onNavigateUp)
            Spacer(modifier = Modifier.height(20.dp))

            Column(Modifier.padding(16.dp)) {
                Text(text = "This app is a demonstration about the navigation component in android Jetpack Compose")
                Spacer(modifier = Modifier.height(20.dp))

                val udemy_link = LocalUriHandler.current
                Button(
                    onClick = {
                        udemy_link.openUri("https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/")
                    },
                ) {
                    Text(text = "Go to our Udemy Link")
                }
            }


        }
    }
}

@Composable
fun Appbar(title: String, onNavigateUp: () -> Unit) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePromoAppTheme {

    }
}