package com.example.composepromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composepromoapp.ui.theme.ComposePromoAppTheme

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePromoAppTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {

                        composable("home") {
                            HomeScreen2(onAboutClick = { navController.navigate("about") },
                                onDetailsClick = {title->
                                    navController.navigate("details/title=$title") })
                        }

                        composable("about") {
                            AboutScreen2(onNavigateUp = { navController.popBackStack() })
                        }

                        composable("details/title={title}",
                            arguments = listOf(
                                navArgument("title") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) { backStackEntry ->
                            val arguments = requireNotNull(backStackEntry.arguments)

                            val title = arguments.getString("title")

                            if (title != null) {
                                DetailsScreen2(
                                    title = title,
                                    onNavigateUp = { navController.popBackStack() })
                            }
                        }
                    }

                }

            }
        }
    }
}

//HomeScreen
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
                CourseCard2(
                    item,
                    onClick = { onDetailsClick(item.title) })
            }
        }
    }

}

@Composable
fun HomeAppBar2(onAboutClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 10.dp)
    ) {

        Text(
            text = "MyUdemy Course",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(onClick = { onAboutClick() }) {
            Text(
                text = "About",
                fontSize = 20.sp
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard2(item: Courses, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        onClick = onClick
    ) {
        Column {
            Image(
                painterResource(id = item.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = item.body,
                maxLines = 1   ,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }

    }

}

//AboutScreen
@Composable
fun AboutScreen2(onNavigateUp: () -> Unit) {

    Scaffold { padding ->
        Column(Modifier.padding(padding)) {
            Appbar2("About") { onNavigateUp() }
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)
            ) {
                Text(text = "This app is a demonstration about the navigation component in android Jetpack Compose")
                Spacer(modifier = Modifier.height(20.dp))

                val udemyLink = LocalUriHandler.current

                Button(onClick = { udemyLink.openUri("https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/\"") }) {
                    Text(text = "Go to our Udemy Link")
                }
            }
        }
    }

}

@Composable
fun Appbar2(title: String, onNavigateUp: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onNavigateUp() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, fontSize = 24.sp )
    }
}

//DetailsScreen
@Composable
fun DetailsScreen2(title: String, onNavigateUp: () -> Unit) {

    val chosen_course2 = allCourses.first { it.title == title }

    Scaffold { padding ->
        Column(Modifier.padding(padding)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                IconButton(onClick = { onNavigateUp() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                }
            }

            Image(
                painterResource(id = chosen_course2.thumbnail),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(
                    text = chosen_course2.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = chosen_course2.body,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = rememberScrollState())
                )
            }
        }
    }
}






