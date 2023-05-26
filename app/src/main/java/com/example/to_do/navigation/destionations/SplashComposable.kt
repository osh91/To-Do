package com.example.to_do.navigation.destionations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.to_do.ui.splash.SplashScreen
import com.example.to_do.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}