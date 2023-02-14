package com.example.pokemonapi.view.viewHolder

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapi.R
import com.example.pokemonapi.commons.StringFormatter
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel

class PokemonViewHolder(private val bind: PokemonRowBinding, val onPokemonItemClick:(Int) -> Unit) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(pokemon: PokemonDetailModel){
//    fun bind(pokemon: PokemonListModel.PokemonListItem, pokemonDetail: PokemonDetailModel) {

        bind.pokeNumber.text = StringFormatter().formatIDToThreeDigitsAndHash(pokemon.id.toString())
        bind.pokeName.text = StringFormatter().formatFirstLetterToUpperCase(pokemon.name)

        Glide.with(itemView)
            .load(pokemon.sprites.frontDefault)
            .into(bind.pixelImg)

        bind.pokeCard.setOnClickListener {
            onPokemonItemClick(pokemon.id)
        }

        when (pokemon.types[0].type.name) {
            "grass" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.grass))
            "fire" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.fire))
            "bug" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.bug))
            "water" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.water))
            "normal" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.normal))
            "poison" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.poison))
            "eletric" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.eletric))
            "flying" -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.flying))
            else -> bind.constraintPokeCardContent.background.setTint(ContextCompat.getColor(bind.root.context,R.color.other))
        }
    }

    private fun getPokemonID(url: String): String {
        return url.split("/").takeLast(2).first()
    }
}