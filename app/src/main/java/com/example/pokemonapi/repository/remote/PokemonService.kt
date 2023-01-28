package com.example.pokemonapi.repository.remote

import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListModel>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailModel>
}