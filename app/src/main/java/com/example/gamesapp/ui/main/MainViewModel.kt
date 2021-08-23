package com.example.gamesapp.ui.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.models.upcoming.GamesList
import com.example.gamesapp.models.upcoming.GamesUpcoming
import com.example.gamesapp.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GamesRepository):ViewModel() {

    private var _games : MutableLiveData<List<GamesList>> = MutableLiveData()
    val games : LiveData<List<GamesList>> get() = _games
    var upcoming :MutableState<List<GamesList>> = mutableStateOf(listOf())


    init{
        upcomingGames()
    }


    fun upcomingGames(){
        viewModelScope.launch(IO) {
            var result = repository.upcomingGames()
//            _games.value = result.gamesLists
            upcoming.value = result.gamesLists
            //Log.v("Salio", result.gamesLists.toString())

        }
    }
}