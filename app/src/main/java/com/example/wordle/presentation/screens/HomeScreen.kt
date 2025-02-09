package com.example.wordle.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordle.R

@Composable

fun HomeScreen(){
    Scaffold (
    ) { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)) {
            LogoHeader()
            InfoBody()
            Buttons()
        }

    }
}

@Preview
@Composable
fun  PreviewHomeScreen(){
    HomeScreen()
}

@Composable
fun LogoHeader(){
    Image(painter = painterResource(id = R.drawable.wordle_logo),
        contentDescription = "Wordle Logo")
}

@Composable
fun InfoBody(){
    Text(
        text = "How to play",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.White,
                offset = Offset(5.0f, 10.0f),
                blurRadius = 3f
            )
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Guess the Wordle in 6 tries",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = " • Each guess must be a valid 5 letter word. ",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
        )
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = " • The color of the tiles will change to show how close your guess was to the word.",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
        )
    )

    Spacer(modifier = Modifier.height(20.dp))



}

@Composable
fun Buttons(){

}