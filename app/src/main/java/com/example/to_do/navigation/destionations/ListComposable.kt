package com.example.to_do.navigation.destionations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do.ui.screens.list.ListScreen
import com.example.to_do.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_do.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(navigateToTaskScreen: (taskId: Int) -> Unit) {
    Log.d("ListComposable", "ListComposable is called from SetupNavigation")
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
        Log.d("ListScreen", "Calling to ListScreen from ListComposable")
    }
}