package com.example.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        selecetedIcon = Icons.Filled.Home,
                        unSelecetedIcon = Icons.Outlined.Home
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Settings",
                        selecetedIcon = Icons.Filled.Settings,
                        unSelecetedIcon = Icons.Outlined.Settings
                    ),
                    MenuItem(
                        id = "help",
                        title = "Help",
                        selecetedIcon = Icons.Filled.Info,
                        unSelecetedIcon = Icons.Outlined.Info
                    )
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    var selectedItemIndex by rememberSaveable {
                        mutableStateOf(0)
                    }

                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            ModalDrawerSheet {
                                DrawerHeader()
                                items.forEachIndexed { index, item ->
                                    NavigationDrawerItem(

                                        label = { Text(text = item.title) },
                                        selected = index == selectedItemIndex,
                                        onClick = {
                                            selectedItemIndex = index
                                            scope.launch {
                                                drawerState.close()
                                            }
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selecetedIcon
                                                } else {
                                                    item.unSelecetedIcon
                                                },
                                                contentDescription = item.title
                                            )
                                        }
                                    )
                                }
                            }
                        }

                    ) {

                        Scaffold(
                            topBar = {
                                TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) },
                                    Modifier.background(MaterialTheme.colorScheme.primary),
                                    navigationIcon = {
                                        IconButton(onClick = { DrawerValue.Open }) {
                                            Icon(
                                                imageVector = Icons.Default.Menu,
                                                contentDescription = "Drawer Icon"
                                            )
                                        }
                                    })
                            },
                            content = { paddingValues -> // Access paddingValues here
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize() // Fill the entire screen
                                        .padding(paddingValues) // Apply the received padding
                                ) {
                                    // Your actual screen content composables here

                                }
                            }
                        )

                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationDrawerTheme {

    }
}