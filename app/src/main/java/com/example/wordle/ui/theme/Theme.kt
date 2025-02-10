package com.example.wordle.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = green_wordle,
    secondary = yellow_wordle,
    tertiary = grey_wordle,
    background = background, // Fondo negro (#000000)
    surface = surface,    // Superficie negra (#000000)
    onBackground = onBackground, // Texto blanco (#FFFFFF)
    onSurface = onSurface    // Texto blanco (#FFFFFF)

)

private val LightColorScheme = lightColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = background, // Fondo negro (#000000)
    surface = surface,    // Superficie negra (#000000)
    onBackground = onBackground, // Texto blanco (#FFFFFF)
    onSurface = onSurface    // Texto blanco (#FFFFFF)
)

@Composable
fun WordleTheme(
    darkTheme: Boolean = true,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}