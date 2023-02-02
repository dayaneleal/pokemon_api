package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.repository.PokemonRepository

class PokemonDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository()

    private val _pokemonDetailLiveData = MutableLiveData<PokemonDetailModel>()
    val pokemonDetailLiveData: LiveData<PokemonDetailModel> = _pokemonDetailLiveData

    private val _errorCheckLiveData = MutableLiveData<Boolean>()
    val errorCheckLiveData: LiveData<Boolean> = _errorCheckLiveData

    fun getPokemonDetail(id: Int) {
        pokemonRepository.getPokemonDetail(id, onSuccess = {
            _errorCheckLiveData.value = true
            _pokemonDetailLiveData.value = it
        }, onError = {
            _errorCheckLiveData.value = false
            Log.d("Debug", it)
        })
    }

}