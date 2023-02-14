package com.example.pokemonapi.repository

import android.content.Context
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.repository.remote.PokemonService
import com.example.pokemonapi.repository.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository(context: Context) : BaseRepository(context) {

    private val service = RetrofitClient.getService(PokemonService::class.java)

//    fun getPokemonList(onSuccess: (PokemonListModel) -> Unit, onError: (String) -> Unit) {
//        executeCall(service.getPokemonList(), onSuccess, onError)
//    }

    suspend fun getPokemonList(): PokemonListModel {
        return withContext(Dispatchers.IO) {
            service.getPokemonList()
        }
    }

//   fun getPokemonDetail(id: Int, onSuccess: (PokemonDetailModel) -> Unit, onError: (String) -> Unit) {
//        executeCall(service.getPokemonDetail(id), onSuccess, onError)
//    }

    suspend fun getPokemonDetail(id: Int): PokemonDetailModel {
        return withContext(Dispatchers.IO) {
            service.getPokemonDetail(id)
        }
    }

}