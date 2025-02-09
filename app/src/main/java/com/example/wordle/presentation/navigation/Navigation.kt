package com.example.wordle.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
class Navigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, StartDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("game") {
            GameScreen()
        }
        composable("score") {
            ScoreScreen()
        }
    }

}