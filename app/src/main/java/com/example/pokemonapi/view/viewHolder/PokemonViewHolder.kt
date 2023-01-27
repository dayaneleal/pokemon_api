package com.example.pokemonapi.view.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonModel

class PokemonViewHolder(private val bind: PokemonRowBinding) : RecyclerView.ViewHolder(bind.root){

    fun bind(pokemon: PokemonModel) {

        bind.pokeNumber.text = pokemon.id.toString()
        bind.pokeName.text = pokemon.name
//        bind.pokeType.text = pokemon.type
    }
}