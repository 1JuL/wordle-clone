package com.example.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wordle.presentation.screens.GameScreen
import com.example.wordle.presentation.screens.HomeScreen
import com.example.wordle.presentation.screens.ScoreScreen
import com.example.wordle.ui.theme.WordleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WordleTheme {
                HomeScreen()
            }
        }
    }
}
