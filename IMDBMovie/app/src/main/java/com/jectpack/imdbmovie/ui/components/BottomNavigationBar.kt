package com.jectpack.imdbmovie.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jectpack.imdbmovie.ui.BottomNavItems

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val bottomNavItems = listOf(
        BottomNavItems.Home,
        BottomNavItems.Search,
        BottomNavItems.News,
        BottomNavItems.Account
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Blue,
        tonalElevation = 5.dp
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}