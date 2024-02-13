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
import androidx.compose.material.icons.rounded.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composepromoapp.ui.theme.ComposePromoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePromoAppTheme {
                // A surface container using the 'background' color from the theme

                //Transparent System Bar
                //Navigation System
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    //Nav Controller
                    val navController = rememberNavController()

                    //NavHost
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {

                        //NavGraph
                        composable("home") {
                            HomeScreen(onAboutClick =
                            { navController.navigate("about") },
                                onDetailsClick = { title ->
                                    navController.navigate("details/title=$title")
                                })
                        }

                        composable("about") {
                            AboutScreen(onNavigateUp = { navController.popBackStack() })
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
                                DetailsScreen(title = title, onNavigateUp = {
                                    navController.popBackStack()
                                })
                            }
                        }

                    }

                }

            }
        }
    }
}


//Home Screen
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
                    onClick = { onDetailsClick(item.title) })
            }
        }
    }
}

//HomeAppBar
@Composable
private fun HomeAppBar(onAboutClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

        Text(
            text = "My Udemy Courses",
            style = MaterialTheme.typography.headlineMedium
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


//About Screen
@Composable
fun AboutScreen(onNavigateUp: () -> Unit) {

    Scaffold { padding ->
        Column(Modifier.padding(padding)) {
            Appbar("About") { onNavigateUp() }
            Spacer(modifier = Modifier.height(20.dp))

            Column(Modifier.padding(16.dp)) {
                Text(text = "This app is a demonstration about the navigation component in android Jetpack Compose")
                Spacer(modifier = Modifier.height(20.dp))

                val udemy_link = LocalUriHandler.current
                Button(
                    onClick = {
                        udemy_link.openUri("https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/")
                    }
                ) {
                    Text(text = "Go to our Udemy Link")
                }
            }


        }
    }
}


@Composable
fun Appbar(title: String, onNavigateUp: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 10.dp)
    ) {

        IconButton(onClick = { onNavigateUp() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Go Back")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, fontSize = 24.sp)
    }

}


//Details Screen
@Composable
fun DetailsScreen(title: String, onNavigateUp: () -> Unit) {

    //Searching for the correct course
    //matching the passed course title
    val chosen_course = allCourses.first { it.title == title }

    Scaffold { padding ->
        Column(Modifier.padding(padding)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                IconButton(onClick = { onNavigateUp() }) {
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Go Back")
                }
            }

            Image(
                painterResource(id = chosen_course.thumbnail),
                contentDescription = "Course Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
            )
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = chosen_course.body,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = rememberScrollState()),
                    fontSize = 16.sp
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePromoAppTheme {

    }
}