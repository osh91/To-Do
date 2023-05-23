package com.example.to_do.ui.screens.task

import android.annotation.SuppressLint

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_do.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(topBar = {
        TaskAppBar(navigationToListScreens = navigateToListScreen)
    }, content = {})
}