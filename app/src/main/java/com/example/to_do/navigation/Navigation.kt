package com.example.to_do.navigation

import Screens
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_do.navigation.destionations.listComposable
import com.example.to_do.navigation.destionations.splashComposable
import com.example.to_do.navigation.destionations.taskComposable
import com.example.to_do.ui.viewmodel.ShareViewModel
import com.example.to_do.util.Constants.SPLASH_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    shareViewModel: ShareViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(navigateToListScreen = screen.splash)
        listComposable(
            navigateToTaskScreen = screen.task,
            shareViewModel = shareViewModel
        )
        taskComposable(
            navigateToListScreen = screen.list,
            shareViewModel = shareViewModel
        )
    }
}