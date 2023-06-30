package com.example.customnavigationbar.screen.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Profile Screen", fontSize = 20.sp)
    }

}