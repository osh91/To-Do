package com.example.to_do.navigation

import Screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_do.navigation.destionations.listComposable
import com.example.to_do.navigation.destionations.taskComposable
import com.example.to_do.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController) {

    val screen = remember(navController) {
        Screens(navController = navController) // hämtar parametrar task , list
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(navigateToTaskScreen = screen.task)
        taskComposable(navigateToListScreen = screen.list)
    }

}