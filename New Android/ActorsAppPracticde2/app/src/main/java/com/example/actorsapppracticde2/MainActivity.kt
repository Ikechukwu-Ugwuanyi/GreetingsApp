package com.example.actorsapppracticde2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.actorsapppracticde2.retrofit.Characters
import com.example.actorsapppracticde2.retrofit.RetrofitInstance
import com.example.actorsapppracticde2.retrofit.repository.CharacterRepository
import com.example.actorsapppracticde2.retrofit.viewmodel.CharacterViewModel
import com.example.actorsapppracticde2.ui.theme.ActorsAppPracticde2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActorsAppPracticde2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    val retrofit = RetrofitInstance.provideApi(RetrofitInstance.getRetrofitInstance())
                    val repository = CharacterRepository(retrofit)
                    val viewmodel = CharacterViewModel(repository)
                    
                    MainScreen(viewModel = viewmodel)

                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CharacterViewModel) {
    val actorz by viewModel.state.collectAsState()
    
    CharacterList(actors = actorz)

}

@Composable
fun CharacterList(actors: List<Characters>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(actors) { item ->
            CardItem(characters = item)

        }
    }

}

@Composable
fun CardItem(characters: Characters) {
    Column {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 4.dp, height = 8.dp)
        ) {
            val painter = rememberAsyncImagePainter(model = characters)

            Image(painter = painter, contentDescription = "Actor Image")
        }
        Text(text = characters.actor, fontSize = 20.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActorsAppPracticde2Theme {

    }
}