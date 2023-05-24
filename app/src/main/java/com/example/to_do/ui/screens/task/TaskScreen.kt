package com.example.to_do.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.to_do.data.models.Priority
import com.example.to_do.data.models.ToDoTask
import com.example.to_do.ui.viewmodel.ShareViewModel
import com.example.to_do.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
    shareViewModel: ShareViewModel
) {
    // Observe för att hämta exemple vad är titlen från task där user har valt
    val title: String by shareViewModel.title
    val description: String by shareViewModel.description
    val priority: Priority by shareViewModel.priority

    val context = LocalContext.current

    Scaffold(topBar = {
        TaskAppBar(
            navigationToListScreens = { action ->
                if (action == Action.NO_ACTION) {
                    navigateToListScreen(action)
                } else {
                    if (shareViewModel.validateFields()) {
                        navigateToListScreen(action)
                    } else {
                        displayToast(context = context)
                    }
                }
            },
            selectedTask = selectedTask
        )
    }, content = {
        TaskContent(
            title = title,
            onTitleChange = {
                shareViewModel.updateTitle(it)
            },
            description = description,
            onDescriptionChange = {
                shareViewModel.description.value = it
            },
            priority = priority,
            onPrioritySelected = {
                shareViewModel.priority.value = it
            }
        )
    })
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty",
        Toast.LENGTH_SHORT
    ).show()
}