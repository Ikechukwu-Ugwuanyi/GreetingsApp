package com.example.composepractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composepractices.ui.theme.ComposePracticesTheme


class TrialAndErrorActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticesTheme {

                val items = listOf("Enugu", "Anambra", "Abia", "Imo", "Onitsha")

                var isExpanded by remember {
                    mutableStateOf(false)
                }

                var city by remember {
                    mutableStateOf("")
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        ExposedDropdownMenuBox(
                            expanded = isExpanded,
                            onExpandedChange = {isExpanded = it}) {

                            OutlinedTextField(
                                value = city,
                                onValueChange = {isExpanded = false},
                                readOnly = true,
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)},
                                label = { Text(text = "Igbo Cities") },
                                modifier =  Modifier.menuAnchor()
                            )

                            ExposedDropdownMenu(
                                expanded = isExpanded,
                                onDismissRequest = { isExpanded = false }) {

                                items.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item)  },
                                        onClick = {
                                            isExpanded = false
                                            city = item
                                        })
                                }

                            }


                        }
                    }

                }
            }
        }
    }

}