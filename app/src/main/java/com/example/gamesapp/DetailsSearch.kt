package com.example.gamesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.gamesapp.models.JuegoDetalles
import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.ui.viewmodels.MainViewModel


@Composable
fun  DetailSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
){
    val juegoDetalles = viewModel.details.component1()

    if(juegoDetalles.platforms.isEmpty()){
        CircularProgressIndicator()
    }else{
        Column(
           modifier= modifier.fillMaxWidth()
                .verticalScroll(rememberScrollState()
                )
        ){
            HeaderHeroSearch(juegoDetalles = juegoDetalles)
        }

    }
}

@Composable

fun HeaderHeroSearch(
    juegoDetalles: GameDetail,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxWidth(),
        //contentAlignment = Alignment.TopCenter,

        ){
        val pintor = rememberImagePainter(data = juegoDetalles.backgroundImage)
        Image(
            painter = pintor, null, alpha = 0.5f,
            modifier = modifier.size(width = 800.dp, height = 450.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            juegoDetalles.name,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center, color = Color.White,
            fontWeight = FontWeight.Bold, modifier = modifier.align(Alignment.BottomCenter)

        )
    }
}