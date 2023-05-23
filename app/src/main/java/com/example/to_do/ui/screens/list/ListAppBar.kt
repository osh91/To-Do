package com.example.to_do.ui.screens.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do.R
import com.example.to_do.components.PriorityItem
import com.example.to_do.data.models.Priority
import com.example.to_do.ui.theme.LARGE_PADDING
import com.example.to_do.ui.theme.Typography
import com.example.to_do.ui.theme.topAppBarBackgroundColor
import com.example.to_do.ui.theme.topAppBarContentColor


@Composable
fun ListAppBar() {
    Log.d("ListAppBar", "ListAppBar called")
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClicked = {})
}

@Composable
fun DefaultListAppBar(onSearchClicked: () -> Unit, onSortClicked: (Priority) -> Unit, onDeleteClicked: () -> Unit) {
    Log.d("ListAppBar", "DeafultListAppBar called")
    TopAppBar(
        title = {
            Text(text = "Task")
        },
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked, onSortClicked = onSortClicked, onDeleteClicked = onDeleteClicked )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(
                R.string.sort_action
            ),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

            ) {
            // * LOW
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }

            // * HIGH
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }

            // * NONE
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            }) {
                PriorityItem(priority = Priority.NONE)
            }
        }
    }

}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(
                R.string.delete_all_action
            ),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()
            }) {
                Text(
                    modifier = Modifier.padding(start = LARGE_PADDING),
                    text = stringResource(R.string.delete_all_action),
                    style = Typography.subtitle2,
                )
            }
        }
    }


}

@Preview
@Composable
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}