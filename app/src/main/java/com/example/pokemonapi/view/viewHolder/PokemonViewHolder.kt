package com.example.pokemonapi.view.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.commons.StringFormatter
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonListModel

class PokemonViewHolder(private val bind: PokemonRowBinding, val onPokemonItemClick:(Int) -> Unit) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(pokemon: PokemonListModel.PokemonListItem) {

        val pokemonID = getPokemonID(pokemon.url)

        bind.pokeNumber.text = StringFormatter().formatIDToThreeDigitsAndHash(pokemonID)
        bind.pokeName.text = StringFormatter().formatFirstLetterToUpperCase(pokemon.name)

        bind.pokeCard.setOnClickListener {
            getPokemonID(pokemonID)
            onPokemonItemClick(pokemonID.toInt())
        }
    }

    fun getPokemonID(url: String): String {
        return url.split("/").takeLast(2).first()
    }
}