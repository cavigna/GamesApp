package com.example.gamesapp.utils

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamesapp.R
import com.example.gamesapp.models.JuegoDetalles
import com.example.gamesapp.ui.theme.GamesAppTheme



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetail() {
    DetailSection()
}

@Composable
fun DetailSection(
    juego: JuegoDetalles = JuegoDetalles(),
    modifier: Modifier = Modifier,
) {
    GamesAppTheme {

        Column(modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())) {
            HeaderHero(juego, modifier)
            Column(modifier.padding(20.dp)) {
               GaleriaImagenes(juego)
                Text(juego.descripcion)

            }
        }



    }

}

@Composable
fun HeaderHero(
    juego: JuegoDetalles,
    modifier: Modifier
) {
    Box(
        modifier.fillMaxWidth()
            , contentAlignment = Alignment.TopCenter
    ) {
        Image(painterResource(juego.imageHero), null, alpha = 0.5f,
        )
        Text(
            juego.name,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center, color = Color.White,
            fontWeight = FontWeight.Bold, modifier = modifier.align(Alignment.BottomCenter)

        )
    }
}

@Composable
fun GaleriaImagenes(
    juego: JuegoDetalles,
    modifier: Modifier = Modifier
){
    val juegosGaleria = juego.galeriaImagenes
    LazyRow(contentPadding = PaddingValues(vertical = 10.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(3){
            Image(
                //painter = painterResource(R.drawable.senuas)

                painter = painterResource(juegosGaleria[it]), contentDescription = null,
                contentScale = ContentScale.Crop, modifier = modifier.size(100.dp)
            )
        }
    }

}




