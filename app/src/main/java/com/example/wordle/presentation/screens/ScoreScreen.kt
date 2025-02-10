package com.example.wordle.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun ScoreScreen(){
    Scaffold (
    ) { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues),
            ) {
            val leaderboard = listOf(
                "Name one - score",
                "Name two - score",
                "Name three - score",
                "Name four - score",
                "Name five - score",
                "Name six - score",
                "Name seven - score",
                "Name eight - score"
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, vertical = 60.dp),
                horizontalAlignment = Alignment.Start
            ) {
                itemsIndexed(leaderboard) { index, item ->
                    Text(
                        text = "${index + 1}. $item",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }

        }

    }
}

@Preview
@Composable
fun  PreviewScoreScreen(){
    ScoreScreen()
}