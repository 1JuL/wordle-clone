package com.example.wordle.domain

import kotlinx.coroutines.flow.Flow

interface FakeScoresDataSource {

    val scores: Flow<List<Score>>

    fun getScores(): List<Score>
    fun addScore(score: Score)
    fun removeScore(score: Score)
}