package com.example.gamesapp.utils.pruebas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamesapp.R
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.iconGamePlataform

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    val painter = painterResource(R.drawable.senuas)
    val titulo = "Senua's Saga: Hellblade II"
    GamesAppTheme {
        //Greeting("Android")
        //Tarjeta(painter, titulo)
        //Listado(painter, titulo)
        //Listado2(juegos)
    }
}

@Composable
fun Listado2(
    listado: List<JuegoPrueba>,
    modifier: Modifier = Modifier
) {
//    Row(modifier.fillMaxWidth()){
//    Text("Latest Games")
//
//}
    Spacer(modifier.size(20.dp))

    LazyColumn {
        items(listado.size) { juego ->
            //var imagen = listado[juego]
            Tarjeta(
                painterResource(
                    listado[juego].image
                ), listado[juego].name,
                listado = listado[juego].plataform
            )
            Spacer(modifier.size(10.dp))
        }
    }
}


@Composable
fun Listado(
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier
) {

    LazyColumn {
        items(20) {
            Tarjeta(painter, title)
            Spacer(modifier.size(10.dp))
        }
    }

}

@Composable
fun Tarjeta(
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier,
    listado: List<String> = listOf("PC", "XBOX")

) {
    Column(modifier.padding(20.dp)) {

        Card(

            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp, backgroundColor = Color.LightGray,
        ) {
            Column {
                Image(
                    painter = painter, null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier.size(10.dp))
                Text(
                    title,
                    modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h3, textAlign = TextAlign.Center,
                    color = Color.White
                )
                Text(
                    "31-12-2021",
                    modifier.align(Alignment.CenterHorizontally),
                    color = Color.White
                )

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    for (i in listado) {
                        Image(
                            painter = painterResource(iconGamePlataform(i)),
                            null,
                            modifier.size(40.dp)
                                .padding(end = 10.dp)

                        )
                    }
                }
            }
        }
    }
}