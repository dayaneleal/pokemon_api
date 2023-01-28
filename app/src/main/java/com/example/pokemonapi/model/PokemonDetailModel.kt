package com.example.pokemonapi.model

data class PokemonDetailModel(
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: PokemonSpriteModel,
    val abilities: List<PokemonAbilityModel>,
    val types: List<PokemonTypeModel>
) {
}
