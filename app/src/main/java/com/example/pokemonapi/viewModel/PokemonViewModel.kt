package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.repository.PokemonRepository

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository()

    private val _listPokemonsLiveData = MutableLiveData<PokemonListModel>()
    val listPokemonsLiveData: LiveData<PokemonListModel> = _listPokemonsLiveData

    private val _pokemonDetailLiveData = MutableLiveData<PokemonDetailModel>()
    val pokemonDetailLiveData: LiveData<PokemonDetailModel> = _pokemonDetailLiveData

    fun getPokemonList() {
        pokemonRepository.getPokemonList(onSuccess = {
            _listPokemonsLiveData.value = it
        }, onError = {
            Log.d("Debug", it)
        })
    }

    fun getPokemonDetail(id: Int) {
        pokemonRepository.getPokemonDetail(id, onSuccess = {
            _pokemonDetailLiveData.value = it
        }, onError = {
            Log.d("Debug", it)
        })
    }
 }