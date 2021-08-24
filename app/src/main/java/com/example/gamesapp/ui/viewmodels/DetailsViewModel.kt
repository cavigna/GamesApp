package com.example.gamesapp.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.models.details.GameDetail
import com.example.gamesapp.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: GamesRepository):ViewModel(){
var details2 : MutableState<GameDetail> = mutableStateOf(GameDetail())


    fun detailGameRespone2(slug: String){
    viewModelScope.launch(IO) {
        val respuesta = repository.detailGameResponse(slug)
        details2.value = respuesta
        }
    }
}