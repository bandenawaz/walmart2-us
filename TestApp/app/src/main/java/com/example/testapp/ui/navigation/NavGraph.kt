package com.example.testapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.ui.DashboardScreen
import com.example.testapp.ui.WelcomeScreen


// Define routes
object Routes {
    const val WELCOME = "welcome"
    const val DASHBOARD = "dashboard"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME // Start with WelcomeScreen
    ) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onGetStartedClick = { navController.navigate(Routes.DASHBOARD) }
            )
        }
        composable(Routes.DASHBOARD) {
            DashboardScreen()
        }
    }
}