package com.example.customnavigationbar.screen.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    var tabIndex by remember { mutableStateOf(0) }
    // declaring the names of TabLayout screens
    val tabScreens = listOf("HomeScreen", "MessageScreen")
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // top bar of TabLayout
        TabRow(selectedTabIndex = tabIndex,
            indicator = { tabPositions -> // 3.
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState,
                        tabPositions
                    )
                )
            }) {
            tabScreens.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) })
            }
        }

        // the Swipe-able Horizontal Tab Layout
        HorizontalPager(
            count = tabScreens.size,
            state = pagerState,
        ) { tabIndex ->
            // Initializing the screens/composable of each Screen
            when(tabIndex) {
                // first screen
                0 -> TabHomeScreen()
                // second screen
                1 -> TabMessageScreen()
            }
        }
    }
}

@Composable
fun TabHomeScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
    ) {

        Text(text = "Home Screen", fontSize = 40.sp)

    }

}

@Composable
fun TabMessageScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
    ) {

        Text(text = "Message Screen", fontSize = 40.sp)

    }

}