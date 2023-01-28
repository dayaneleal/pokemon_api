package com.example.pokemonapi.model

data class PokemonListModel(
    val count: Int,
    val results: List<PokemonListItem>
) {

    data class PokemonListItem(
        val name: String,
        val url: String
    )
}
