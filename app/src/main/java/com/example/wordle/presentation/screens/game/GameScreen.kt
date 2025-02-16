package com.example.wordle.presentation.screens.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wordle.R
import com.example.wordle.presentation.components.OnScreenKeyboard
import com.example.wordle.presentation.components.WordBox
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(onBack: () -> Unit, viewModel: GameViewModel = viewModel()) {

    val openAlertDialog = remember { mutableStateOf(false) }
    val gameWon = remember { mutableStateOf(false) }

    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { openAlertDialog.value = false },
            viewModel = viewModel,
            dialogTitle = if (gameWon.value) "Congratulations!" else "You Lost!",
            dialogText = if (gameWon.value) "You Won!" else "Better Luck Next Time!"
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Wordle") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.restart() }) {
                        Icon(Icons.Sharp.Refresh, contentDescription = "Replay")
                    }

                }
            )
        },
        containerColor = colorResource(id = R.color.black_wordle)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            WordGrid(
                attempts = viewModel.attempts,
                currentAttempt = viewModel.currentAttempt,
                solution = viewModel.target
            )

            Spacer(modifier = Modifier.height(40.dp))

            OnScreenKeyboard(
                onKeyPressed = { letter -> viewModel.onKeyPressed(letter) },
                onBackspace = { viewModel.onBackspace() }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.onSubmit()
                    if (viewModel.gameWon) {
                        gameWon.value = true
                        openAlertDialog.value = true
                    } else if (viewModel.gameOver) {
                        gameWon.value = false
                        openAlertDialog.value = true
                    }
                },
                modifier = Modifier.width(350.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.green_wordle),
                    contentColor = Color.White
                )
            ) {
                Text("Submit")
            }
        }
    }
}

fun getColorsForAttempt(attempt: String, solution: String): List<Int> {
    val result = MutableList(5) { 0 }
    val letterFrequency = mutableMapOf<Char, Int>()
    solution.forEach { ch ->
        letterFrequency[ch] = letterFrequency.getOrDefault(ch, 0) + 1
    }

    for (i in attempt.indices) {
        if (i < solution.length && attempt[i] == solution[i]) {
            result[i] = 3  // verde
            letterFrequency[attempt[i]] = letterFrequency[attempt[i]]!! - 1
        }
    }

    for (i in attempt.indices) {
        if (result[i] != 3) {
            if (letterFrequency.getOrDefault(attempt[i], 0) > 0) {
                result[i] = 2  // amarillo
                letterFrequency[attempt[i]] = letterFrequency[attempt[i]]!! - 1
            } else {
                result[i] = 1  // gris
            }
        }
    }
    return result
}

@Composable
fun WordGrid(
    attempts: List<String>,
    currentAttempt: String,
    solution: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (row in 0 until 6) {
            val word = when {
                row < attempts.size -> attempts[row]
                row == attempts.size -> currentAttempt
                else -> ""
            }
            val colors = if (row < attempts.size && word.length == 5) {
                getColorsForAttempt(word, solution)
            } else {
                listOf(0, 0, 0, 0, 0)
            }
            WordBox(word = word, colors = colors)
        }
    }
}

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    viewModel: GameViewModel,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.restart()
                    onDismissRequest()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBFE8FF),
                    contentColor = Color.Black
                ),
                border = BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Restart")
            }
        }
    )
}