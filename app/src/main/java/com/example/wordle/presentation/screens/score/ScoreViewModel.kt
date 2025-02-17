package com.example.wordle.presentation.screens.score

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wordle.data.FakeScoresDataSource
import com.example.wordle.domain.Score

class ScoreViewModel : ViewModel() {
    private val localDataSource = FakeScoresDataSource

    var scores by mutableStateOf(listOf<Score>())
        private set

    init {
        scores = localDataSource.getScores()
    }
}