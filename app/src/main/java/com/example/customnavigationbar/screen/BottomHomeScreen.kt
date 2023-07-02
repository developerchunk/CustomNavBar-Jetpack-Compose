package com.example.customnavigationbar.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customnavigationbar.ui.theme.Purple500
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomHomeScreen() {

    // Special thanks to Burak(itnext.io) on Medium for the detailed article on TabLayout
    // link to article- https://itnext.io/tabs-tablayout-in-jetpack-compose-cd1f84d3a381

    //pagerState will be necessary to remember & keep the state of the pager.
    //coroutineScope will be used for pagerState scrolling.
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val interactionSource = remember {
        MutableInteractionSource()
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        bottomBar = {

            //We first add TabRow which will be the container for Tab.
            //
            //selectedTabIndex, the index of the currently selected tab.
            //
            //indicator, that represents which tab is currently selected. but we don't need it so we made it Transparent
            TabRow(
                backgroundColor = Color.White,
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = Color.Transparent
                    )
                }
            ) {

                //Inside of the TabRow we will create Tab. Since we’ve already created tabs list, we’ll simply call tabRowItems.forEachIndex and set Tabs.
                //
                //selected, whether this tab is selected or not.
                //
                //In onClick method, we launch the coroutineScope and call animateScrollToPage function. It simply animates to the given page to the middle of the viewport.
                tabRowItems.forEachIndexed { index, item ->

                    Tab(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = interactionSource,
                                onClick = {
                                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                                }
                            )
                        ,
                        selected = pagerState.currentPage == index,
                        onClick = {
                                  // we have already added the clickable in the Modifier
                        },
                        text = {
                            BottomNavItem(
                                item.title,
                                icon = item.icon,
                                selected = pagerState.currentPage == index,
                                interactionSource = interactionSource,
                                onCLick = {
                                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                                }
                            )
                        }
                    )
                }
            }

        }
    ) {

        //HorizontalPager A horizontally scrolling layout that allows users to flip between items to the left and right.
        //
        //Finally, we’ll add HorizontalPager. count is the number of pages and state is the object to be used to control or observe the pager’s state which we’ve already created above.
        //
        //Inside of the HorizontalPager, we’ll get current page and call screens.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HorizontalPager(
                count = tabRowItems.size,
                state = pagerState,
            ) { count ->
                when (count) {
                    0 -> TabHomeScreen()
                    1 -> TabReportScreen()
                    2 -> TabProfileScreen()
                }
            }
        }
    }


}

data class TabRowItem(
    val title: String,
    val icon: ImageVector,
)

val tabRowItems = listOf(
    TabRowItem(
        title = "Home",
        icon = Icons.Rounded.Home,
    ),
    TabRowItem(
        title = "Report",
        icon = Icons.Rounded.Info,
    ),
    TabRowItem(
        title = "Profile",
        icon = Icons.Rounded.AccountCircle,
    )
)

@Composable
fun BottomNavItem(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    interactionSource: MutableInteractionSource,
    onCLick: () -> Unit
) {

    val background =
        if (selected) Purple500.copy(alpha = 0.6f) else Color.Transparent

    val contentColor =
        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = { onCLick() }
            )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = title,
                    color = contentColor
                )
            }
        }
    }
}


// our screens
// home screen
@Composable
fun TabHomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Text(text = "Home Screen", fontSize = 40.sp)

    }

}

// report screen
@Composable
fun TabReportScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Text(text = "Report Screen", fontSize = 40.sp)

    }

}

// profile screen
@Composable
fun TabProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Text(text = "Profile Screen", fontSize = 40.sp)

    }

}