package com.example.pokemonapi.model

import com.google.gson.annotations.SerializedName

data class PokemonSprite(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("other")
    val other: PokemonSpriteHome
) {
    data class PokemonSpriteHome(
        @SerializedName("official-artwork")
        val officialArtwork: PokemonSpriteFrontDefault
    ) {
        data class PokemonSpriteFrontDefault(
            @SerializedName("front_default")
            val frontDefault: String
        )
    }
}