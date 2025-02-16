package com.example.wordle.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnScreenKeyboard(onKeyPressed: (Char) -> Unit, onBackspace: () -> Unit) {
    val keyboardRows = listOf(
        "QWERTYUIOP",
        "ASDFGHJKL",
        "ZXCVBNM⌫"
    )

    Column(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        keyboardRows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
            ) {
                row.forEach { key ->
                    KeyboardKey(
                        label = key.toString(),
                        onClick = {
                            if (key == '⌫') onBackspace() else onKeyPressed(key)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun KeyboardKey(label: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFBFE8FF),
            contentColor = Color.Black
        ),
        shape = RectangleShape,
        modifier = Modifier.width(35.dp),
        contentPadding = PaddingValues(0.dp)

    ) {
        Text(text = label, fontSize = 16.sp, modifier = Modifier.padding(0.dp))
    }
}

@Preview
@Composable
fun KeyboardPreview() {
    OnScreenKeyboard(
        onKeyPressed = { key -> println("Key pressed: $key") },
        onBackspace = { println("Backspace pressed") }
    )
}