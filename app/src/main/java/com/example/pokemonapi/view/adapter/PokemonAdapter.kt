package com.example.pokemonapi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.view.viewHolder.PokemonViewHolder

class PokemonAdapter(): RecyclerView.Adapter<PokemonViewHolder>() {

    private var pokemonList: List<PokemonListModel.PokemonListItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val pokemon = PokemonRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(pokemon)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.count()
    }

    fun updateList( list: List<PokemonListModel.PokemonListItem>){
        pokemonList = list
        notifyDataSetChanged()
    }

}