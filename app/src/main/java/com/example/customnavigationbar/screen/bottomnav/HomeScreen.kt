package com.example.customnavigationbar.screen.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val tabTitles = listOf("HomeScreen", "MessageScreen")
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = tabTitles.size,
            state = pagerState,
        ) { tabIndex ->
            when(tabIndex) {
                0 -> TabHomeScreen()
                1 -> TabMessageScreen()
            }
        }
    }
}

@Composable
fun TabHomeScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)) {

        Text(text = "Home Screen", fontSize = 40.sp)
    }

}

@Composable
fun TabMessageScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)) {
        Text(text = "Message Screen", fontSize = 40.sp)
    }

}