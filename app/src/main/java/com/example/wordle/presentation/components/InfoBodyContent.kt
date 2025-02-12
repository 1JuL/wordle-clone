package com.example.wordle.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBodyContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "How To Play",
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.5.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Guess the Wordle in 6 tries",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "• Each guess must be a valid 5-letter word",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "• The color of the tiles will change to show how close your guess was to the word",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Examples",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        WordBox(
            word = "WORDY",
            colors = listOf(3, 0, 0, 0, 0)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "W is in the word and in the correct spot",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        WordBox(
            word = "LIGHT",
            colors = listOf(0, 2, 0, 0, 0)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "I is in the word but in the wrong spot",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        WordBox(
            word = "ROGUE",
            colors = listOf(0, 0, 0, 1, 0)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "U is not in the word in any spot",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}