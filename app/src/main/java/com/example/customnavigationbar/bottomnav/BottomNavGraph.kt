package com.example.customnavigationbar.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.customnavigationbar.screen.bottomnav.HomeScreen
import com.example.customnavigationbar.screen.bottomnav.ProfileScreen
import com.example.customnavigationbar.screen.bottomnav.ReportScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route)
        {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Report.route)
        {
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route)
        {
            ProfileScreen()
        }
    }
}