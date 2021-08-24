package com.example.gamesapp.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.gamesapp.models.JuegoDetalles
import com.example.gamesapp.models.upcoming.GamesList
import com.example.gamesapp.ui.theme.GamesAppTheme



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetail() {
    //DetailSection()
}

@Composable
fun DetailSection(
    juegoPrueba: JuegoDetalles = JuegoDetalles(),
    modifier: Modifier = Modifier,
    name:String,
    slug: String,
    heroImage:String,
    juego: GamesList? = null
) {
    GamesAppTheme {

        Column(modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())) {
            HeaderHero(juegoPrueba, modifier, name, heroImage)
            Column(modifier.padding(20.dp)) {
               GaleriaImagenes(juegoPrueba)
                Text(juegoPrueba.descripcion, style = MaterialTheme.typography.body2
                ,lineHeight = 20.sp)

            }
        }



    }

}

@Composable
fun HeaderHero(
    juegoPrueba: JuegoDetalles,
    modifier: Modifier,
    name: String,
    heroImage: String,
    juegoApi: GamesList? = null
) {
    Box(
        modifier.fillMaxWidth()
            , contentAlignment = Alignment.TopCenter
    ) {
        val pintor = rememberImagePainter(data = heroImage)
        Image(painter = pintor, null, alpha = 0.5f,
        )
        Text(
            name,
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
        items(juegosGaleria.size){
            Image(
                //painter = painterResource(R.drawable.senuas)

                painter = painterResource(juegosGaleria[it]), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(width = 215.dp, height = 110.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }

}




