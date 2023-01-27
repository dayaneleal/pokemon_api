package com.example.pokemonapi.repository.remote

import com.example.pokemonapi.model.PokemonModel
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon/2")
    fun getPokemon(): Call<PokemonModel>
}