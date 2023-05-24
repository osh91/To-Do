package com.example.to_do.navigation.destionations

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do.ui.screens.list.ListScreen
import com.example.to_do.ui.viewmodel.ShareViewModel
import com.example.to_do.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_do.util.Constants.LIST_SCREEN
import com.example.to_do.util.toAction

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    shareViewModel: ShareViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        Log.d("ListComposable", action.name)

        LaunchedEffect(key1 = action) {
            shareViewModel.action.value = action
        }
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            shareViewModel = shareViewModel
        )
    }
}