package com.example.gamesapp.utils.pruebas

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamesapp.R
import com.example.gamesapp.models.JuegoDetalles
import com.example.gamesapp.ui.theme.GamesAppTheme

import com.example.gamesapp.ui.theme.*
import com.example.gamesapp.utils.colorPlataformPiker
import com.example.gamesapp.utils.iconGamePlataformParent
import com.example.gamesapp.utils.iconGameStore


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetail() {
   DetailSectionPrueba()
}

@Composable
fun DetailSectionPrueba(
    juego: JuegoDetalles = JuegoDetalles(),
    modifier: Modifier = Modifier,
) {
    GamesAppTheme {

        Column(
            modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            HeaderHeroPrueba(juego, modifier)
            Column(modifier.padding(20.dp)) {
                GaleriaImagenesPrueba(juego)

                Text("About", style = MaterialTheme.typography.h5)
                Text(
                    juego.descripcion,
                    style = MaterialTheme.typography.body2,
                    lineHeight = 20.sp,
                    maxLines = 3,
                    modifier = modifier.padding(5.dp)
                )
                DetallesInfoPrueba()
            }
        }


    }

}

@Composable
fun HeaderHeroPrueba(
    juego: JuegoDetalles,
    modifier: Modifier
) {
    Box(
        modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painterResource(juego.imageHero), null, alpha = 0.5f,
        )
        Text(
            juego.name,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center, color = Color.White,
            fontWeight = FontWeight.Bold, modifier = modifier.align(Alignment.BottomCenter),


            )
    }
}

@Composable
fun GaleriaImagenesPrueba(
    juego: JuegoDetalles,
    modifier: Modifier = Modifier
) {
    val juegosGaleria = juego.galeriaImagenes
    LazyRow(
        contentPadding = PaddingValues(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(juegosGaleria.size) {
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

@Composable
fun DetallesInfoPrueba1(
    modifier: Modifier = Modifier
) {
    val listadoDePlataformas = listOf(
        "PC", "Xbox One", "Xbox Series S/X"
    )
    val listadoString = listadoDePlataformas.joinToString()
    Row(
        modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(100.dp)

    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Column {
                Text("Plataforms")
                Text(listadoString, fontSize = 12.sp)

            }


        }
        Row(horizontalArrangement = Arrangement.Start) {
            Text("Genre")
        }
    }


}

@Composable
fun DetallesInfoPrueba(
    modifier: Modifier = Modifier
) {
    val listadoDePlataformas = listOf(
        "PC", "Xbox One", "Xbox Series S/X", "PlayStation 5"
    )
    val listadoGenero = listOf(
        "Action", "Shooter", "Adventure"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        MetaScoreBoxPrueba()
        Text("DeveloperDetail", style = MaterialTheme.typography.h6)
        Card(
            modifier = modifier.size(height = 20.dp, width = 100.dp),
            shape = RoundedCornerShape(2.dp),
            backgroundColor = Teal200
        ) {
            Text("343 Industries")
        }
        Spacer(modifier.size(10.dp))

        Text("Plataforms", style = MaterialTheme.typography.h6)

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            for (l in listadoDePlataformas) {
                    Card(
                        modifier = modifier.size(height = 35.dp, width = 100.dp),
                        shape = RoundedCornerShape(5.dp),
                        backgroundColor = colorPlataformPiker(l)

                    ) {
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(
                                l,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.button,
                                color = Color.White,
                                modifier = modifier.fillMaxSize()

                            )
                        }
                    }
            }
        }
        Spacer(modifier.size(10.dp))

        Text("Genres", style = MaterialTheme.typography.h6)

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            for (g in listadoGenero) {
                Card(
                    modifier = modifier.size(height = 20.dp, width = 100.dp),
                    shape = RoundedCornerShape(2.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Text(g, textAlign = TextAlign.Center, style = MaterialTheme.typography.caption)
                }
            }
        }

        Spacer(modifier.size(10.dp))

        Text("Buy", style = MaterialTheme.typography.h6)

        val listadoStore = listOf("Epic Games", "Steam")

        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            items(listadoStore.size) {
                Card(
                    modifier = modifier.size(height = 75.dp, width = 125.dp),
                    shape = RoundedCornerShape(2.dp),
                    backgroundColor = Color.LightGray
                ) {
                    var nombreJuego = listadoStore[it]
                    var logo = iconGameStore(nombreJuego)
                    Row {
                        Text(
                            nombreJuego,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Icon(
                            painterResource(logo), null,
                            tint = Color.White,
                            modifier = modifier.size(50.dp)
                        )
                    }
                }
            }
        }

    }


}

@Composable
fun MetaScoreBoxPrueba(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.size(30.dp), contentAlignment = Alignment.Center
    ){
        Card(modifier = modifier.fillMaxSize()
            .align(Alignment.Center)
            .size(40.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, Color.Green),
            backgroundColor = Color.Transparent

            ){
            Text("45", textAlign = TextAlign.Center, fontSize = 25.sp)
        }


    }
}




