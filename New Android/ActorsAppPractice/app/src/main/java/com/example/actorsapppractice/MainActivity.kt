package com.example.actorsapppractice

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.actorsapppractice.repository.CharacterRepository
import com.example.actorsapppractice.retrofit.Characters
import com.example.actorsapppractice.retrofit.RetrofitInstance
import com.example.actorsapppractice.ui.theme.ActorsAppPracticeTheme
import com.example.actorsapppractice.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActorsAppPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val retrofitInstance =
                        RetrofitInstance.provideApi(RetrofitInstance.getRetrofitInstance())
                    val repository = CharacterRepository(retrofitInstance)
                    val viewModel = CharacterViewModel(repository)
                        
                    MainScreen(viewModel = viewModel)

                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CharacterViewModel){
    val characterz by viewModel.state.collectAsState()

    CharacterList(charactersList = characterz)

}

@Composable
fun CharacterList(charactersList: List<Characters>){
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)){

        items(items = charactersList){
            item -> CardItem(characters = item)
        }

    }
}


@Composable
fun CardItem(characters: Characters) {
    Column {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 140.dp, height = 180.dp),
            contentAlignment = Alignment.Center
        )
        {
            val painter = rememberAsyncImagePainter(model = characters.image)
            Image(painter = painter, contentDescription = "Actor Image")
        }

        Text(text = characters.actor, fontSize = 20.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActorsAppPracticeTheme {

    }
}