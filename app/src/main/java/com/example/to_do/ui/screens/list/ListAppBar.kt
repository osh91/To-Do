package com.example.to_do.ui.screens.list

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListAppBar() {
DefaultListAppBar()
}

@Composable
fun DefaultListAppBar() {
    TopAppBar(title = {
        Text(text = "Task")
                      }, backgroundColor = MaterialTheme.colors.primary)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DefaultListAppBarPreview() {
    DefaultListAppBar()
}