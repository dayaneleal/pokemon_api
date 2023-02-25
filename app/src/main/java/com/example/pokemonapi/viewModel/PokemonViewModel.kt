package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.pokemonapi.commons.ApiStatus
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository(application.applicationContext)

    private val _listPokemonsLiveData = MutableLiveData<List<PokemonDetailModel>>()
    val listPokemonsLiveData: LiveData<List<PokemonDetailModel>> = _listPokemonsLiveData

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    fun getPokemonList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try{
                _status.value = ApiStatus.DONE
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
            } catch(e: Exception) {
                _status.value = ApiStatus.ERROR
                _listPokemonsLiveData.value = listOf()
            }

        }
    }

    private fun getPokemonID(url: String): String {
        return url.split("/").takeLast(2).first()
    }
}