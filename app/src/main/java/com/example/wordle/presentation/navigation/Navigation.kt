package com.example.wordle.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wordle.presentation.screens.HomeScreen
import com.example.wordle.presentation.screens.game.GameScreen
import com.example.wordle.presentation.screens.score.ScoreScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen>{
            HomeScreen(onPLayGame = {
                navController.navigate(GameScreen)
            },
                onScore = {
                    navController.navigate(ScoreScreen)
                })
        }
        composable<GameScreen> {
            GameScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable<ScoreScreen> {
            ScoreScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}


@Serializable
object HomeScreen

@Serializable
object GameScreen

@Serializable
object ScoreScreen