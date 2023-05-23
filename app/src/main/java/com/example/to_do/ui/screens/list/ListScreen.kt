package com.example.to_do.ui.screens.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do.R
import com.example.to_do.ui.theme.fabBackgroundColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Log.d("ListScreen", "Is called")
    Scaffold(
        topBar = { ListAppBar() },
        content = {},
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
            Log.d("ListFab", "onFabClicked called")
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

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}