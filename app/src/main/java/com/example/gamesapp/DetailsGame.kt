package com.example.gamesapp.utils

import android.util.Log
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.ui.theme.greyCool
import com.example.gamesapp.ui.viewmodels.MainViewModel

//private val viewModel: MainViewModel by viewModels()
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetail() {
    //DetailSection()
}

@Composable
fun DetailSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val juegoDetalles = viewModel.details.component1()
    var isExpanded = remember { mutableStateOf(false) }
    GamesAppTheme {

        if (juegoDetalles.platforms.isEmpty()) {
            CircularProgressIndicator()
        } else {

            Column(
                modifier.fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {

                Log.v("convertidor", stringToSlug(juegoDetalles.name))
                Log.v("convertidorOriginal", juegoDetalles.slug)

                SearchBar(viewModel = viewModel)
                HeaderHero(modifier, viewModel = viewModel)

                Column(modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {

                    GaleriaImagenes(viewModel = viewModel)

                    Text("Description", style = MaterialTheme.typography.h6)


                    Text(
                        juegoDetalles.descriptionRaw,
                        style = MaterialTheme.typography.body2,
                        lineHeight = 20.sp,
                        modifier = modifier.padding(5.dp)
//                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 1,
//                    overflow = if (isExpanded.value) TextOverflow.Visible else TextOverflow.Ellipsis,

                    )

                    GameInfoDetails(juegoDetalles = juegoDetalles)

                }
            }

        }
    }

}

@Composable
fun HeaderHero(
    modifier: Modifier,
    viewModel: MainViewModel,
) {

    val juegoModel = viewModel.currentGame.value!!
    val heroImage = juegoModel.backgroundImage
    Box(
        modifier.fillMaxWidth(),
        //.padding(vertical = 20.dp)
        contentAlignment = Alignment.TopCenter,

        ) {
        val pintor = rememberImagePainter(data = heroImage)
        Image(
            painter = pintor, null, alpha = 0.5f,
            modifier = modifier.size(width = 800.dp, height = 450.dp),
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
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val juegos = viewModel.currentGame.value!!
    val juegosGaleria = juegos.shortScreenshots
    LazyRow(
        contentPadding = PaddingValues(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(juegosGaleria.size) {
            var current = juegosGaleria[it]
            var pintor = rememberImagePainter(data = current.image)
            Image(
                painter = pintor, contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(width = 215.dp, height = 110.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun GameInfoDetails(
    juegoDetalles: GameDetail,
    modifier: Modifier = Modifier,
    // viewModel: MainViewModel
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        if (!juegoDetalles.developers.isNullOrEmpty()) {
            Text("Developer", style = MaterialTheme.typography.h6)
            Card(
                modifier = modifier.size(height = 30.dp, width = 100.dp),
                shape = RoundedCornerShape(2.dp),
                backgroundColor = greyCool
            ) {
                Text(juegoDetalles.developers[0].name)
                Log.v("vevo", juegoDetalles.toString())
            }
            Spacer(modifier.size(10.dp))
        }


        Text("Plataforms", style = MaterialTheme.typography.h6)

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(juegoDetalles.platforms.size) {

                var nombrePlataforma = juegoDetalles.platforms[it].platform.name

                Card(
                    modifier = modifier.size(height = 40.dp, width = 100.dp),
                    shape = RoundedCornerShape(2.dp),
                    backgroundColor = colorPlataformPiker(nombrePlataforma)
                ) {
                    Text(
                        nombrePlataforma,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                        modifier = modifier.align(Alignment.CenterHorizontally),

                        )
                }
            }
        }

//        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
//            for (l in juegoDetalles.platforms) {
//                Card(
//                    modifier = modifier.size(height = 20.dp, width = 100.dp),
//                    shape = RoundedCornerShape(2.dp),
//                    backgroundColor = colorPlataformPiker(l.platform.name)
//                ) {
//                    Text(l.platform.name, textAlign = TextAlign.Center, style = MaterialTheme.typography.caption)
//                }
//            }
//        }

        Spacer(modifier.size(10.dp))

        Text("Genres", style = MaterialTheme.typography.h6)

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            var listadoGenero = juegoDetalles.genres
            for (g in listadoGenero) {
                Card(
                    modifier = modifier.size(height = 30.dp, width = 100.dp),
                    shape = RoundedCornerShape(2.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Text(
                        g.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

        Spacer(modifier.size(10.dp))

        Text("Buy", style = MaterialTheme.typography.h6)

        val listadoStore = juegoDetalles.stores

        LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            items(listadoStore.size) {
                var logo = iconGameStore(listadoStore[it].store.name)
                Icon(
                    painterResource(logo), null,
                    tint = Color.White,
                    modifier = modifier.size(50.dp)                )
            }
        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    viewModel: MainViewModel,
    onSearch: (String) -> Unit = { }
) {
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                //viewModel.detailGameRespone(text)
                //onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = modifier.fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search),

            leadingIcon = { Icon(Icons.Filled.Search, null)},

           keyboardActions =  KeyboardActions(
                onSearch = {
                    viewModel.detailGameRespone(text)
                    defaultKeyboardAction(imeAction = ImeAction.Done)
                }
            ),
        )
    }
}

//                .onFocusChanged {
//                    isHintDisplayed = it != FocusState.Active
//                }

//        if (isHintDisplayed){
//            Text(hint, color = Color.LightGray,
//            modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp)
//                )
//        }


/*
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    viewModel: MainViewModel
   // onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                //viewModel.detailGameRespone(text)
                //onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = modifier.fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            leadingIcon = { Icon(Icons.Filled.Search, null)},


        )

    }
}
 */



