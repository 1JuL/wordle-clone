package com.example.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var target by mutableStateOf("HAPPY")
        private set
    var attempts by mutableStateOf(listOf<String>())
        private set
    var currentAttempt by mutableStateOf("")
        private set

    fun onSubmit(){
        //Verificar si la palabra es correcta
        //Verificar si no tiene mas intentos
        //Agregar la palabra a la lista de intentos
        // currentAttempt = ""

    }

    fun resetGame(){

    }

    fun onKeyPressed(){

    }

    fun onDelete(){

    }
}