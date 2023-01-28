package com.example.pokemonapi.view.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonListModel

class PokemonViewHolder(private val bind: PokemonRowBinding) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(pokemon: PokemonListModel.PokemonListItem) {

        val pokemonID = getPokemonID(pokemon.url)

        bind.pokeNumber.text = "#" + pokemonID.padStart(3, '0')

        bind.pokeName.text = pokemon.name.replaceFirstChar(Char::uppercase)

        bind.pokeCard.setOnClickListener {
            getPokemonID(pokemonID)
        }
    }

    fun getPokemonID(url: String): String {
        return url.split("/").takeLast(2).first()
    }
}