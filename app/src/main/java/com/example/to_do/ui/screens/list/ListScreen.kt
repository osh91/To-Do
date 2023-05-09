package com.example.to_do.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do.R
import com.example.to_do.ui.theme.ToDoTheme

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit
) {
    ToDoTheme { //todo this is wrong it has to change
        Scaffold(
            topBar = { ListAppBar()},
            content = { Text(text = "BodyContent")},
            floatingActionButton = {
                ListFab(onFabClicked = navigateToTaskScreen)
            }
        )
    }
}

// todo this is working in darktheme and lighttheme
//@Composable
//fun ListScreen(navigateToTaskScreen: (Int) -> Unit) {
//    ToDoTheme {
//        Scaffold(
//            topBar = { ListAppBar() },
//            content = { Text(text = "BodyContent") },
//            floatingActionButton = {
//                ListFab(onFabClicked = navigateToTaskScreen)
//            }
//        )
//    }
//}


@Composable
fun ListFab(
    onFabClicked: (Int) -> Unit
) {
    FloatingActionButton(onClick = {
        onFabClicked(-1) // från Screens task, där taskId, man bestämmer -1 är att öppna action button
    }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(R.string.add_button), tint = Color.White)

    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}