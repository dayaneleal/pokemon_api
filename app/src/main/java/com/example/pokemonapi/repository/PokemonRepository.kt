package com.example.pokemonapi.repository

import com.example.pokemonapi.model.PokemonModel
import com.example.pokemonapi.repository.remote.PokemonService
import com.example.pokemonapi.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    private val service = RetrofitClient.getService(PokemonService::class.java)

    fun getPokemon() {
        val call = service.getPokemon()

        call.enqueue(object: Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                val s = ""
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                val s = ""
            }

        })
    }
}