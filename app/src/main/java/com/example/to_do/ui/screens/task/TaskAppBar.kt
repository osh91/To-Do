package com.example.to_do.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do.R
import com.example.to_do.components.DisplayAlertDialog
import com.example.to_do.data.models.Priority
import com.example.to_do.data.models.ToDoTask
import com.example.to_do.ui.theme.topAppBarBackgroundColor
import com.example.to_do.ui.theme.topAppBarContentColor
import com.example.to_do.util.Action

@Composable
fun TaskAppBar(
    navigationToListScreens: (Action) -> Unit,
    selectedTask: ToDoTask?,
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigationToListScreens = navigationToListScreens)
    } else {
        ExcitingTaskAppBar(
            selectedTask = selectedTask,
            navigationToListScreens = navigationToListScreens
        )
    }
}

@Composable
fun NewTaskAppBar(
    navigationToListScreens: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigationToListScreens)
        },
        title = {
            Text(
                text = stringResource(R.string.add_task),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onBackClicked = navigationToListScreens)
        }
    )
}


@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {

    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun AddAction(
    onBackClicked: (Action) -> Unit
) {

    IconButton(onClick = { onBackClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {

    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {

    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {

    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun ExcitingTaskAppBar(
    selectedTask: ToDoTask,
    navigationToListScreens: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigationToListScreens)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ExistingTaskAppBarActions(
                selectedTask = selectedTask,
                navigateToListScreen = navigationToListScreens
            )
        }
    )
}

@Composable
fun ExistingTaskAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    var openDialog by remember { mutableStateOf(false) }

    DisplayAlertDialog(
        title = stringResource(
            id = R.string.delete_task,
            selectedTask.title
        ),
        message = stringResource(
            id = R.string.delete_task_confirmation,
            selectedTask.title
        ),
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { navigateToListScreen(Action.DELETE) }
    )

    DeleteAction(onDeleteClicked = { openDialog = true })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}

@Preview
@Composable
fun NewTaskAppBarPrview() {
    NewTaskAppBar(navigationToListScreens = {})
}

@Preview
@Composable
fun ExcistingTaskAppBarPrview() {
    ExcitingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            "Oshiz",
            description = "some random text",
            priority = Priority.LOW
        ), navigationToListScreens = {})
}