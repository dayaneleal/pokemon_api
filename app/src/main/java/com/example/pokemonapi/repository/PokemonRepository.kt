package com.example.pokemonapi.repository

import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.repository.remote.PokemonService
import com.example.pokemonapi.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    private val service = RetrofitClient.getService(PokemonService::class.java)

    fun getPokemonList(onSuccess: (PokemonListModel) -> Unit, onError: (String) -> Unit) {
        val call = service.getPokemonList()

        call.enqueue(object : Callback<PokemonListModel> {
            override fun onResponse(
                call: Call<PokemonListModel>,
                response: Response<PokemonListModel>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        onSuccess(it)
                    }
                } else {
                    onError(response.errorBody()?.string() ?: "Error: Body vazio.")
                }
            }

            override fun onFailure(call: Call<PokemonListModel>, t: Throwable) {
                onError("Erro inesperado: ${t.message}")
            }

        })
    }


}