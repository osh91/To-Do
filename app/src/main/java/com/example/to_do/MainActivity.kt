package com.example.to_do

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.to_do.navigation.SetupNavigation
import com.example.to_do.ui.theme.ToDoTheme
import com.example.to_do.ui.viewmodel.ShareViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    // Hello, denna här under är den rätta. Tyvärr har ViewModel med HiltDagger fått bugg, RIP. Orka fixa.
//    private val sharedViewModel: ShareViewModel by viewModels()
    private lateinit var sharedViewModel: ShareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        sharedViewModel = ViewModelProvider(this).get(ShareViewModel::class.java)


        setContent {
            ToDoTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController, shareViewModel = sharedViewModel)
            }
        }
    }
}

