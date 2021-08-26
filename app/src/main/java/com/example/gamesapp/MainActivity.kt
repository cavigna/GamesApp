package com.example.gamesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.material.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.gamesapp.models.upcoming.GamesList
//import com.example.gamesapp.navigation.Navigation
import com.example.gamesapp.ui.viewmodels.MainViewModel
import com.example.gamesapp.ui.theme.GamesAppTheme
import com.example.gamesapp.utils.DetailSection
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


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
                            UpcomingSection(gamesList, navController = navController, viewModel = viewModel)
                        }
                        //var juego = navController.previousBackStackEntry?.arguments?.getParcelable<GamesList>("book")
                        composable("detail_screen",
                       //composable("detail_screen/juegoList = {juegoList}/{name}/{color}/{fecha}",
                        //composable("detail_screen/{name}/{slug}/{juegoList}",
                            arguments = listOf(
                                //navArgument("name") { type = NavType.StringType},
                                //navArgument("slug") { type = NavType.StringType},
                                //navArgument("heroImage") { type = NavType.StringType},
                                navArgument("juegoList"){type = NavType.StringType}




                            )

                        ) { juego ->

//                            val nombre = remember {
//                                juego.arguments?.getString("name")
//                            }
//                            val slug = juego.arguments?.getString("slug")!!
//                            val heroImage = remember{
//                                juego.arguments?.getString("heroImage")!!
//                            }
                            val juegaso = Gson().fromJson(juego.arguments!!.getString("juegoList"), GamesList::class.java)

                            DetailSection(viewModel = viewModel )
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

