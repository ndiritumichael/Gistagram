package com.vickikbt.gistagram.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vickikbt.gistagram.ui.screens.auth.AuthScreen
import com.vickikbt.gistagram.ui.screens.home.HomeScreen
import com.vickikbt.gistagram.ui.screens.notifications.NotificationsScreen
import com.vickikbt.gistagram.ui.screens.search.SearchScreen
import com.vickikbt.gistagram.ui.screens.settings.SettingsScreen
import com.vickikbt.gistagram.ui.screens.webview.WebViewScreen

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {

    // val defaultEnterAnimationDuration = 600
    // val defaultExitAnimationDuration = 1100
    // val slideDefaultInitialOffset = 1800
    // val slideDefaultTargetOffset = 1500

    NavHost(navController = navController, startDestination = NavigationItem.Auth.route) {
        composable(route = NavigationItem.Auth.route) {
            AuthScreen(navController = navController)
        }
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(route = NavigationItem.Notifications.route) {
            NotificationsScreen(navController = navController)
        }

        composable(route = NavigationItem.Profile.route) {
            //ProfileScreen(navController = navController)
        }

        composable(route = NavigationItem.Settings.route) {
            SettingsScreen(navController = navController)
        }

        composable(
            route = NavigationItem.WebView.route
            //arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) {
            //val webviewUrl = it.arguments?.getString("url")

            WebViewScreen()
        }
    }
}
