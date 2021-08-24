package com.example.gamesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.gamesapp.models.JuegoPrueba
import com.example.gamesapp.models.upcoming.GamesList
//import com.example.gamesapp.navigation.Navigation
import com.example.gamesapp.ui.viewmodels.MainViewModel
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.DetailSection
import com.example.gamesapp.utils.iconGamePlataform
import com.example.gamesapp.utils.pruebas.DetailSectionPrueba
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    //val navController = rememberNavController()


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel.upcomingGames()
        setContent {
            val gamesList = viewModel.upcoming.value
            GamesAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main_screen") {
                        composable(
                            "main_screen",

                            ) {
                            UpcomingSection(gamesList, navController = navController)
                        }
                        composable("detail_screen/{name}/{slug}/{heroImage}",
                            arguments = listOf(
                                navArgument("name") { type = NavType.StringType},
                                navArgument("slug") { type = NavType.StringType},
                                navArgument("heroImage") { type = NavType.StringType},



                            )
                        ) { juego ->

                            val nombre = remember {
                                juego.arguments?.getString("name")
                            }
                            val slug = juego.arguments?.getString("slug")!!
                            val heroImage = juego.arguments?.getString("heroImage")!!

                            DetailSection(name = nombre!!, slug = slug, heroImage = heroImage)
                        }
                    }


                }
            }
        }

//        lifecycleScope.launch {
//            viewModel.upcomingGames()
//            viewModel.games.observe(this@MainActivity) {
//                Log.v("Salio", viewModel.games.value.toString())
//            }
//        }
//    }
//
//        lifecycleScope.launch {
//            viewModel.detailGameRespone("halo-infinite")
//            viewModel.prueba.observe(this@MainActivity){
//                Log.v("estamos bien", viewModel.prueba.value.toString())
//            }
//                Log.v("Salio", viewModel.details.component1().toString())
//
//        }


    }


//@Composable
//fun initListado(gamesList: List<GamesList>) {
//    if (gamesList.isEmpty()) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            CircularProgressIndicator()
//        }
//        UpcomingSection(gamesList)
//    }
//}

    //                            val juegaso = remember{
//                                juego.arguments!!.getString("game").let {
//                                    Gson().fromJson(it, GamesList::class.java)
//                                }
//                            }



}

