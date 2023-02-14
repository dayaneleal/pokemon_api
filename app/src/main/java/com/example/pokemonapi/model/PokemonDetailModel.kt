package com.example.pokemonapi.model

data class PokemonDetailModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: PokemonSprite,
    val types: List<PokemonType>
) {
    data class PokemonType(val type: PokemonTypeInfo)
    {
        data class PokemonTypeInfo(val name: String)
    }

}
