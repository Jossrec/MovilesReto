package com.example.reto

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold


import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.auth0.android.Auth0

import com.example.reto.navigation.AppNavigation
import com.example.reto.room.UserRepository
import com.example.reto.room.UsersDataBase
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.viewmodels.UserViewModel
import com.example.reto.viewmodels.UserViewModelFactory


class MainActivity : ComponentActivity() {
    private lateinit var account: Auth0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the database
        val database = Room.databaseBuilder(
            applicationContext,
            UsersDataBase::class.java, "app_database"
        ).build()

        account = Auth0.getInstance(
            "wa4SSdJ72KqCxwOOSp5osSTbXbPvyPBl",
            "dev-6511lhqrk7y4e42z.us.auth0.com"
        )

        // Create the repository and the ViewModel
        val userRepository = UserRepository(database.userDao())
        val userViewModel = ViewModelProvider(
            this,
            UserViewModelFactory(userRepository)
        )[UserViewModel::class.java]

        setContent {
            RetoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen(userViewModel = userViewModel, account = account)
                }
            }
        }
    }
}

@Composable
fun MainScreen(userViewModel: UserViewModel, account: Auth0) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            AppNavigation(navController = navController, userViewModel = userViewModel,auth0 = account)
        }
    }
}