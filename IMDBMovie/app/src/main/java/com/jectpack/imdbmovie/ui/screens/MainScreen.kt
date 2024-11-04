package com.jectpack.imdbmovie.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jectpack.imdbmovie.ui.BottomNavItems
import com.jectpack.imdbmovie.ui.activity.MainActivity
import com.jectpack.imdbmovie.ui.components.BottomNavigationBar

@Composable
fun MainScreen(mainActivity: MainActivity) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Search.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItems.Home.route) {
                HomeScreen(mainActivity)
            }
            composable(BottomNavItems.Search.route) {
                SearchScreen()
            }
            composable(BottomNavItems.News.route) {
                NewsScreen()
            }
            composable(BottomNavItems.Account.route) {
                AccountScreen()
            }
        }
    }
}