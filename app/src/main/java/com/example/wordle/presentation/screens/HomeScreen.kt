package com.example.wordle.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wordle.R
import com.example.wordle.presentation.components.InfoBodyContent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

@Composable

fun HomeScreen(){
    Scaffold { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)) {
            LogoHeader()
            InfoBody()
            Buttons()
        }

    }
}

@Composable
fun LogoHeader() {
    Image(
        painter = painterResource(id = R.drawable.wordle_logo),
        contentDescription = "Wordle Logo",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, vertical = 35.dp),
    )
}

@Composable
fun InfoBody(){
    InfoBodyContent()
}

@Composable
fun Buttons(){
    Column (
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        Button(onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.green_wordle),
                contentColor = Color.White
            )
        ) {
            Text("Let's Play!")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.green_wordle),
                contentColor = Color.White
            )
        ) {
            Text("Leaderboard")
        }
    }

}