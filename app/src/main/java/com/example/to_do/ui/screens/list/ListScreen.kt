package com.example.to_do.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.to_do.R
import com.example.to_do.ui.theme.fabBackgroundColor
import com.example.to_do.ui.viewmodel.ShareViewModel
import com.example.to_do.util.SearchAppBarState

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    shareViewModel: ShareViewModel
) {
    // * Hämtar ner datan, alla task för att du använder ViewModel-Flow
    LaunchedEffect(key1 = true) {
        shareViewModel.getAllTasks()
    }

    val searchAppBarState: SearchAppBarState by shareViewModel.searchAppBarState
    val searchTextState: String by shareViewModel.searchTextState

    val allTasks by shareViewModel.allTasks.collectAsState()

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = shareViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        // content är kroppen - body till Scaffold
        content = { ListContent(tasks = allTasks, navigateToTaskScreen = navigateToTaskScreen) },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}


@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1) // från Screens task, där taskId, man bestämmer -1 är att öppna action button
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}