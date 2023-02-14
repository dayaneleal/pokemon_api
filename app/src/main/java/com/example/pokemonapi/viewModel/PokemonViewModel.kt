package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository(application.applicationContext)

    private val _listPokemonsLiveData = MutableLiveData<List<PokemonDetailModel>>()
    val listPokemonsLiveData: LiveData<List<PokemonDetailModel>> = _listPokemonsLiveData

    fun getPokemonList() {
        viewModelScope.launch {
//            pokemonRepository.getPokemonList(onSuccess = {
////            _listPokemonsLiveData.value = it
//
//                val list = mutableListOf<PokemonDetailModel>()
//
//                it.results.map { item ->
//                    val id = getPokemonID(item.url).toInt()
//                    pokemonRepository.getPokemonDetail(id,
//                        onSuccess = { detailModel ->
//                            list.add(detailModel)
//                        }, onError = {})
//                }
//
//                _listPokemonsLiveData.value = list
//
//            }, onError = {
//                Log.d("Debug", it)
//            })

            val result: PokemonListModel = pokemonRepository.getPokemonList()
            val list = mutableListOf<PokemonDetailModel>()
            result.results.map { item ->
                val id = getPokemonID(item.url).toInt()

                val pokemonDetail: PokemonDetailModel = pokemonRepository.getPokemonDetail(id)
                list.add(
                    pokemonDetail
                )
            }

            _listPokemonsLiveData.value = list

        }
    }

    private fun getPokemonID(url: String): String {
        return url.split("/").takeLast(2).first()
    }
}