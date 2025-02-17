package com.example.wordle.data

import com.example.wordle.domain.FakeScoresDataSource
import com.example.wordle.domain.Score
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object FakeScoresDataSource: FakeScoresDataSource{

    private val _scores = MutableStateFlow<List<Score>>(emptyList())

    override val scores: Flow<List<Score>>
        get() = _scores


    override fun getScores(): List<Score> {
        return _scores.value
    }

    override fun addScore(score: Score) {
        val scores = _scores.value.toMutableList()
        scores.add(score)
        _scores.value = scores
    }

    override fun removeScore(score: Score) {
        val scores = _scores.value.toMutableList()
        scores.remove(score)
        _scores.value = scores
    }
}