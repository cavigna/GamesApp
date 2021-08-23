package com.example.gamesapp.utils

/*
package com.example.gamesapp

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.Constants.juegos


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun listPreview() {
    GamesAppTheme {
        upcomingSection(juegos)

    }
}

@Composable
fun upcomingSection(
    listadojuegos: List<JuegoPrueba>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth().padding(10.dp)) {
            Text("Upcoming Games", modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h3, textAlign = TextAlign.Center,)
        }

        Row(modifier.padding(20.dp)) {
            ListadoUpcoming(juegos)
        }
    }

}

@Composable
fun ListadoUpcoming(
    listadojuegos: List<JuegoPrueba>,
    modifier: Modifier = Modifier
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        items(listadojuegos.size){
            TarjetaJuego(listadojuegos[it])
        }
    }

}

@Composable
fun TarjetaJuego(
    juegoPrueba: JuegoPrueba,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp, backgroundColor = Color.LightGray,

    ) {
        Column {
            Image(
                painter = painterResource(juegoPrueba.image),
                null,
                contentScale = ContentScale.Fit,
                modifier = modifier.fillMaxWidth()
            )

            Spacer(modifier.size(10.dp))
            Text(
                juegoPrueba.name,
                modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h4, textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                juegoPrueba.date,
                modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )
        }

    }



}



 */

/*
package com.example.gamesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.lifecycle.lifecycleScope
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.ui.main.MainViewModel
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.Constants.juegos
import com.example.gamesapp.utils.iconGamePlataform
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.upcomingGames()
        setContent {
            GamesAppTheme {
                val painter = painterResource(R.drawable.senuas)
                val titulo = "Senusas"
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Listado(painter, titulo)
                    Listado2(juegos)
                    Row {
                        Text(viewModel.games.value?.get(0)?.name.toString())
                    }
                }
            }
        }

        lifecycleScope.launch {
            viewModel.upcomingGames()
            viewModel.games.observe(this@MainActivity) {
                Log.v("Salio", viewModel.games.value.toString())
            }
        }
    }

}


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
        Listado2(juegos)
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


 */

/*
package com.example.gamesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.Constants.juegos


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun listPreview() {
    GamesAppTheme {
        upcomingSection(juegos)

    }
}

@Composable
fun upcomingSection(
    listadojuegos: List<JuegoPrueba>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth().padding(10.dp)) {
            Text("Upcoming Games", modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h3, textAlign = TextAlign.Center,)
        }

        Row(modifier.padding(20.dp)) {
            ListadoUpcoming(listadojuegos)
        }
    }

}

@Composable
fun ListadoUpcoming(
    listadojuegos: List<JuegoPrueba>,
    modifier: Modifier = Modifier
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(listadojuegos.size){
            TarjetaJuego(listadojuegos[it], modifier.background(MaterialTheme.colors.primary))
        }
    }

}

@Composable
fun TarjetaJuego(
    juegoPrueba: JuegoPrueba,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp, backgroundColor = MaterialTheme.colors.primary,

    ) {
        Column {
            Image(
                painter = painterResource(juegoPrueba.image),
                null,
                contentScale = ContentScale.Fit,
                modifier = modifier.fillMaxWidth()
            )

            //Spacer(modifier.size(10.dp))
            Text(
                juegoPrueba.name,
                modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h4, textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                juegoPrueba.date,
                modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )
        }

    }



}



 */


/*
//            val painter = rememberImagePainter(data = juego.backgroundImage)
//            val painterState = painter.state
//
//            if(painterState is ImagePainter.State.Loading){
//                CircularProgressIndicator()
//            }
//            Image(
//                painter =Glide.with(Image).load
//                null,
//                contentScale = ContentScale.Fit,
//                modifier = modifier.fillMaxWidth()
//            )
            /*
                            Glide.with(imageViewBook.context)
                    .load(image)
                    .fitCenter()
                    .into(imageViewBook)

https://api.rawg.io/media/crop/600/400/games/5dd/5dd4d2dd986d2826800bc37fff64aa4f.jpg
https://media.rawg.io/media/games/5dd/5dd4d2dd986d2826800bc37fff64aa4f.jpg

             */
            //GlideImage(data=juego.backgroundImage)

            /*******/
            val context = LocalContext.current

            val imageLoader = ImageLoader(context)

            val request = ImageRequest.Builder(context).data(juego.backgroundImage)
                .build()

            val imagePainter = rememberImagePainter(request = request,
            imageLoader = imageLoader)
            imageLoader.enqueue(request)





 */