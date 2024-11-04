package com.jectpack.imdbmovie.ui

import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object  Home : BottomNavItems("home", AppBottomNavIcons.Home, "Home")
    object  Search : BottomNavItems("search", AppBottomNavIcons.Search, "Search")
    object  News : BottomNavItems("news", AppBottomNavIcons.News, "News")
    object  Account : BottomNavItems("account", AppBottomNavIcons.Account, "Account")
}