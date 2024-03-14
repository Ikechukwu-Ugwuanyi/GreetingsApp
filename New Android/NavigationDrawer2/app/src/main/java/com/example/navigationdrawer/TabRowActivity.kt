package com.example.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme

class TabRowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {

                val items = listOf(
                    TabItem(
                        "Home",
                        Icons.Filled.Home,
                        Icons.Outlined.Home
                    ),
                    TabItem(
                        "Browse",
                        Icons.Filled.ShoppingCart,
                        Icons.Outlined.ShoppingCart
                    ),
                    TabItem(
                        "Account",
                        Icons.Filled.AccountCircle,
                        Icons.Outlined.AccountCircle
                    ),
                )
                var selectedTabIndex by remember {
                    mutableIntStateOf(0)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier =
                        Modifier.fillMaxSize()
                    ) {

                        TabRow(selectedTabIndex = selectedTabIndex) {
                            items.forEachIndexed { index, tabItem ->
                                Tab(selected = index == selectedTabIndex,
                                    onClick = { selectedTabIndex = index },
                                    text = {
                                        Text(text = tabItem.title)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedTabIndex) {
                                                tabItem.selectedIcon
                                            } else {
                                                tabItem.unselectedIcon
                                            },
                                            contentDescription = tabItem.title
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class TabItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)