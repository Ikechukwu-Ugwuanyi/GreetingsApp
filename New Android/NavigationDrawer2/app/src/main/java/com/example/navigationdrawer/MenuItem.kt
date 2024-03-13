package com.example.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val selecetedIcon: ImageVector,
    val unSelecetedIcon: ImageVector
)
