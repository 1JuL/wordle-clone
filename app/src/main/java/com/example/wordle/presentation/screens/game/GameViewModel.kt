package com.example.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wordle.data.allWords

class GameViewModel : ViewModel() {
    var target by mutableStateOf(getRandomWord())
        private set

    var currentAttempt by mutableStateOf("")
        private set

    var attempts by mutableStateOf(listOf<String>())
        private set

    val gameOver: Boolean
        get() = (attempts.isNotEmpty() && attempts.last() == target) || (attempts.size >= 6)

    val gameWon: Boolean
        get() = (attempts.isNotEmpty() && attempts.last() == target)


    private fun getRandomWord(): String {
        return allWords.random()
    }
    fun restart() {
        target = getRandomWord()
        currentAttempt = ""
        attempts = emptyList()
    }

    fun onKeyPressed(letter: Char) {
        if (!gameOver && currentAttempt.length < 5) {
            currentAttempt += letter
        }
    }

    fun onBackspace() {
        if (!gameOver && currentAttempt.isNotEmpty()) {
            currentAttempt = currentAttempt.dropLast(1)
        }
    }

    fun onSubmit() {
        if (!gameOver && currentAttempt.length == 5) {
            attempts = attempts + currentAttempt
            currentAttempt = ""
        }
    }
}
