package com.example.gamesapp

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.models.upcoming.GamesList
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.Constants.juegos
import com.example.gamesapp.utils.iconGamePlataform
import com.google.gson.Gson
import dev.chrisbanes.accompanist.glide.GlideImage


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun listPreview() {
    GamesAppTheme {
        //upcomingSection(juegos)
    }
}


@ExperimentalMaterialApi
@Composable
fun UpcomingSection(
    listadojuegos: List<GamesList>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),


    ) {
        Row(modifier = modifier
            //.size(width = 300.dp, height = 200.dp)
            .fillMaxWidth().padding(10.dp)) {
            Text(
                "Upcoming Games", modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h3, textAlign = TextAlign.Center,
            )
        }

        Row(modifier.padding(20.dp)) {
            ListadoUpcoming(listadojuegos, navController = navController)
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun ListadoUpcoming(
    listadojuegos: List<GamesList>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {

        items(listadojuegos.size) {
            var juego = listadojuegos[it]
            TarjetaJuego(
                juego, modifier.background(MaterialTheme.colors.primary), navController = navController
            )

        }
    }

}


@ExperimentalMaterialApi
@Composable
fun TarjetaJuego(
    juego: GamesList,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    fun unidorRuta(vararg rutas:String):String{
        return buildString {
            append("detail_screen")
                rutas.forEach{ruta->
                    append("/${ruta}")
                }

        }
    }
//    fun pasarObjeto(juegoApasar: GamesList = juego){
//        val juegoJson = Gson().toJson(juego).toString()
//        navController.navigate("detail_screen/${juego.name}/$juegoJson")
//    }
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp, backgroundColor = MaterialTheme.colors.primary,
        onClick = {
            //navController.navigate("detail_screen/${juego.name}/${juego.slug}" )
            navController.navigate(
                unidorRuta(juego.name, juego.slug, juego.backgroundImage)
            )
        }
        ) {
        Column {

            //"https://api.rawg.io/media/crop/600/400/games/5dd/5dd4d2dd986d2826800bc37fff64aa4f.jpg"

            ImagenLista(juego.backgroundImage)

            //Log.v("webjuego", juego.backgroundImage)

            //Spacer(modifier.size(10.dp))
            Text(
                juego.name,
                modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h4, textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                juego.released,
                modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )

            Row(
                modifier.fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.End
            ) {
                val plataformasPadres = juego.parentPlatforms
                val listaPataformaAdmitidas = plataformasPadres.filter {
                    it.platform.slug == "pc" || it.platform.slug == "xbox" ||
                            it.platform.slug == "playstation"
                }

                for (plataforma in listaPataformaAdmitidas ) {


                    Image(
                        painter = painterResource(iconGamePlataform(plataforma.platform.slug)),
                        null,
                        modifier.size(30.dp)
                            .padding(end = 10.dp)

                    )

                    Log.v("plata", plataforma.platform.slug)

                }
            }
        }

    }


}

@Composable
fun ImagenLista(imagen: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        val pintor = rememberImagePainter(data = imagen)
        Image(
            painter = pintor,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 400.dp, height = 200.dp)
                .fillMaxSize()
        )
    }

}


