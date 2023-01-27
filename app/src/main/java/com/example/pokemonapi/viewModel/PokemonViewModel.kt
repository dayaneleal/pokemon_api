package com.example.pokemonapi.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pokemonapi.repository.PokemonRepository

class PokemonViewModel(application: Application): AndroidViewModel(application) {

    private val pokemonRepository = PokemonRepository()

    fun getPokemon() {

        pokemonRepository.getPokemon()
    }
}