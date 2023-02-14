package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository(application.applicationContext)

    private val _pokemonDetailLiveData = MutableLiveData<PokemonDetailModel>()
    val pokemonDetailLiveData: LiveData<PokemonDetailModel> = _pokemonDetailLiveData

//    private val _pokemonDetailListLiveData = MutableLiveData<List<PokemonDetailModel>>()
//    val pokemonDetailListLiveData: LiveData<List<PokemonDetailModel>> = _pokemonDetailListLiveData

    private val _errorCheckLiveData = MutableLiveData<Boolean>()
    val errorCheckLiveData: LiveData<Boolean> = _errorCheckLiveData


    fun getPokemonDetail(id: Int) {
        viewModelScope.launch {
            val result: PokemonDetailModel = pokemonRepository.getPokemonDetail(id)
            _pokemonDetailLiveData.value = result
        }
//        pokemonRepository.getPokemonDetail(id, onSuccess = {
//            _errorCheckLiveData.value = true
//            _pokemonDetailLiveData.value = it
//        }, onError = {
//            _errorCheckLiveData.value = false
//            Log.d("Debug", it)
//        })

    }

//    fun getListPokemonDetail() {
//            for (i in 1..20) {
//                pokemonRepository.getPokemonDetail(i, onSuccess = { list.add(it) }, onError = {})
//            }
//            _pokemonDetailListLiveData.value = list
//    }

}