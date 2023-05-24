package com.example.to_do.navigation.destionations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do.ui.screens.task.TaskScreen
import com.example.to_do.ui.viewmodel.ShareViewModel
import com.example.to_do.util.Action
import com.example.to_do.util.Constants
import com.example.to_do.util.Constants.TASK_ARGUMENT_KEY

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    shareViewModel: ShareViewModel,
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        shareViewModel.getSelectedTask(taskId = taskId)

        val selectedTask by shareViewModel.selectedTask.collectAsState()

        // ! skicka inte in parameter taskId i key1 för att Corutine pioriterar senare shareViewModel
        // ! selectedTask känner av det vilket id du väljer
        // sedan skickades det vidare till updateTaskFields
        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                shareViewModel.updateTaskFields(selectedTask = selectedTask)
            }

        }

        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask,
            shareViewModel = shareViewModel
        )
    }
}