package com.example.pokemonapi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.PokemonRowBinding
import com.example.pokemonapi.model.PokemonDetailModel
import com.example.pokemonapi.model.PokemonListModel
import com.example.pokemonapi.view.viewHolder.PokemonViewHolder

class PokemonAdapter(val onPokemonItemClick:(id: Int) -> Unit): RecyclerView.Adapter<PokemonViewHolder>() {

    private var pokemonList: List<PokemonDetailModel> = emptyList()
//    private var pokemonWithDetailsList: List<PokemonDetailModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val pokemon = PokemonRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(pokemon, onPokemonItemClick)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
//        holder.bind(pokemonList[position], pokemonWithDetailsList[position])
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.count()
    }

    fun updateList( list: List<PokemonDetailModel>){
        pokemonList = list
        notifyDataSetChanged()
    }

//    fun updateListPokemonWithDetails( list: List<PokemonDetailModel>){
//        pokemonWithDetailsList = list
//        notifyDataSetChanged()
//    }

}