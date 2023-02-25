package com.example.pokemonapi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemonapi.commons.ApiStatus
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository(application.applicationContext)

    private val _pokemonDetailLiveData = MutableLiveData<PokemonDetailModel>()
    val pokemonDetailLiveData: LiveData<PokemonDetailModel> = _pokemonDetailLiveData

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    fun getPokemonDetail(id: Int) {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try{
                _status.value = ApiStatus.DONE
                val result: PokemonDetailModel = pokemonRepository.getPokemonDetail(id)
                _pokemonDetailLiveData.value = result
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR

            }
        }

        }

}