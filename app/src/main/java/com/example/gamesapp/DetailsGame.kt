package com.example.gamesapp.utils

import androidx.activity.viewModels
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
import com.example.gamesapp.ui.viewmodels.MainViewModel

//private val viewModel: MainViewModel by viewModels()
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetail() {
    //DetailSection()
}

@Composable
fun DetailSection(
    juegoPrueba: JuegoDetalles = JuegoDetalles(),
    modifier: Modifier = Modifier,
    name:String= "Halo",
    slug: String = "halo",
    heroImage:String? = null,
    juego: GamesList? = null,
    viewModel: MainViewModel
) {
    GamesAppTheme {

        Column(modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())) {
            HeaderHero(juegoPrueba, modifier, name, viewModel = viewModel)
            Column(modifier.padding(20.dp)) {
               GaleriaImagenes( viewModel = viewModel)
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
    //heroImage: String,
    juegoApi: GamesList? = null,
    viewModel: MainViewModel,
) {

    val juegoModel = viewModel.currentGame.value!!
    val heroImage =juegoModel.backgroundImage
    Box(
        modifier.fillMaxWidth()
            //.padding(vertical = 20.dp)
            , contentAlignment = Alignment.TopCenter,

    ) {
        val pintor = rememberImagePainter(data = heroImage)
        Image(painter = pintor, null, alpha = 0.5f,
            modifier = modifier.size(width = 400.dp, height = 200.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            juegoModel.name,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center, color = Color.White,
            fontWeight = FontWeight.Bold, modifier = modifier.align(Alignment.BottomCenter)

        )
    }
}

@Composable
fun GaleriaImagenes(
    juego: JuegoDetalles? = null,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
){
    val juegos = viewModel.currentGame.value!!
    val juegosGaleria = juegos.shortScreenshots
    LazyRow(contentPadding = PaddingValues(vertical = 10.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(juegosGaleria.size){
            //var pintor = rememberImagePainter(data = imagen)
            Image(
                painter = rememberImagePainter(data = juegosGaleria[it].image), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(width = 215.dp, height = 110.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }

    //painter = painterResource(R.drawable.senuas)

}




