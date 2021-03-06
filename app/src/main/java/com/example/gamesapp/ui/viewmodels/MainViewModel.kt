package com.example.gamesapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.models.upcoming.GamesList
import com.example.gamesapp.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GamesRepository):ViewModel() {



    var upcoming :MutableState<List<GamesList>> = mutableStateOf(listOf())
    var searchMutableListGame :MutableState<List<GamesList>> = mutableStateOf(listOf())
    var details : MutableState<GameDetail> = mutableStateOf(GameDetail())
    var bestGamesYearMutable : MutableState<List<GamesList>> = mutableStateOf(listOf())


    private var _games : MutableLiveData<List<GamesList>> = MutableLiveData()
    val games : LiveData<List<GamesList>> get() = _games

    private var _prueba : MutableLiveData<GameDetail> = MutableLiveData()
    val prueba : LiveData<GameDetail> get() = _prueba

    private var _currentGame : MutableLiveData<GamesList> = MutableLiveData()
    val currentGame : LiveData<GamesList> get() = _currentGame

    private var _currentGameDetails : MutableLiveData<GameDetail> = MutableLiveData()
    val currentGameDetails : LiveData<GameDetail> get() = _currentGameDetails


    init{
        upcomingGames()
        //bestGamesOfYear()
    }


    fun upcomingGames(){
        viewModelScope.launch(IO) {
            var result = repository.upcomingGames()
//            _games.value = result.gamesLists
            upcoming.value = result.gamesLists
            //Log.v("Salio", result.gamesLists.toString())

        }
    }

    fun searchGamesList(queryGame:String){
        viewModelScope.launch {
            searchMutableListGame.value = repository.searchGame(queryGame).gamesLists
            upcoming.value = repository.searchGame(queryGame).gamesLists
        }
    }

    fun detailGameRespone(slug: String){
        viewModelScope.launch(IO) {
            val respuesta = repository.detailGameResponse(slug)
            _currentGameDetails.postValue(respuesta)
            details.value = respuesta

        }
    }

     fun bestGamesOfYear(){
         viewModelScope.launch {
             bestGamesYearMutable.value =  repository.bestGameOfYear().gamesLists
             upcoming.value = repository.bestGameOfYear().gamesLists
         }
     }

    fun currentGamePutter(gamesList: GamesList){
        viewModelScope.launch {
            _currentGame.postValue(gamesList)
        }
    }



    fun prueba(slug: String){
        viewModelScope.launch {
            val result = repository.prueba(slug)
            Log.v("poronga", result.raw().request().url().toString())
            //otromas = result.body()!!
        }
    }

//    fun currentGameDetail(){
//        viewModelScope.launch (IO){
//            val respuesta = repository
//        }
//    }
}