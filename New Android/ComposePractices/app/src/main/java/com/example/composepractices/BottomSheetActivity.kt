package com.example.composepractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractices.ui.theme.ComposePracticesTheme

class BottomSheetActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val sheetState = rememberModalBottomSheetState()
                    var isSheetOpen by remember {
                        mutableStateOf(false)
                    }

                    val scaffoldState = rememberBottomSheetScaffoldState()
                    val scope = rememberCoroutineScope()

                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center) {

                        Button(onClick = {
                            isSheetOpen = true
                        }) {
                            Text(text = "Open Sheet")
                        }
                    }

                    if (isSheetOpen){
                        ModalBottomSheet(
                            sheetState = sheetState,
                            onDismissRequest = {
                                isSheetOpen = false
                            }) {
                            Image(painterResource(id = R.drawable.woman),
                                contentDescription = null)
                        }
                    }

//                    BottomSheetScaffold(
//                        sheetContent = {
//                            Image(
//                                painterResource(id = R.drawable.woman),
//                                contentDescription = null)
//                        },
//                        sheetPeekHeight = 10.dp
//                    ) {
//                        Box(modifier = Modifier.fillMaxSize(),
//                            contentAlignment = Alignment.Center) {
//
//                            Button(onClick = {
//                                scope.launch {
//                                    scaffoldState.bottomSheetState.expand()
//                                }
//                            }) {
//                                Text(text = "Open Sheet")
//                            }
//                        }
//                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposePracticesTheme {

    }
}