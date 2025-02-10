package com.example.wordle.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordle.R

@Composable
fun WordBox(
    word: String,
    colors: List<Int> = listOf(0, 0, 0, 0, 0)
) {
    val maxLetters = 5
    val letters = word.take(maxLetters).toCharArray()
    val colorStates = colors.take(maxLetters)


    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until maxLetters) {
            val letter = if (i < letters.size) letters[i].toString() else ""
            val currentColorState = colorStates.getOrElse(i) { 0 }

            val boxColor = when (currentColorState) {
                1 -> colorResource(id = R.color.grey_wordle)        // Gris
                2 -> colorResource(id = R.color.yellow_wordle)      // Amarillo
                3 -> colorResource(id = R.color.green_wordle)       // Verde
                else -> colorResource(id = R.color.black_wordle)    // Negro
            }

            val showBorder = currentColorState == 0

            Surface(
                modifier = Modifier.size(50.dp),
                color = Color.Transparent,
                border =
                if (showBorder) {
                    BorderStroke(2.dp, Color.Gray)
                } else{
                    null
                },
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.background(boxColor)
                ) {
                    Text(
                        text = letter.uppercase(),
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}