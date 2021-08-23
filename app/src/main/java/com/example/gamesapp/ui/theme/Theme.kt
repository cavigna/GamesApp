package com.example.gamesapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(

    primary = blue200,
    primaryVariant = VeryDarkGrey,
    secondary = yellow200,
    surface = blueDarkPrimary

/*
//primary = Purple200,
    primary = VeryDarkGrey,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Color.DarkGray,
    //onBackground = Color.White,
    background = Color.LightGray
 */

)

private val LightColorPalette = lightColors(

    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GamesAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors =  DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

/*
private val DarkColorPalette = darkColors(

    primary = Color.DarkGray,
    //primary = VeryDarkGrey,
    primaryVariant = Color.White,
    secondary = VeryDarkGrey,
   //surface = VeryDarkGrey,
    //onBackground = Color.White,
    background = Color.White

/*
//primary = Purple200,
    primary = VeryDarkGrey,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Color.DarkGray,
    //onBackground = Color.White,
    background = Color.LightGray
 */

)

private val LightColorPalette = lightColors(

    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GamesAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
 */