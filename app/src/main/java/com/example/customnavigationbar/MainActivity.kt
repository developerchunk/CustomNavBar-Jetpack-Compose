package com.example.customnavigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.customnavigationbar.screen.MainScreen
import com.example.customnavigationbar.ui.theme.CustomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomNavigationBarTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}