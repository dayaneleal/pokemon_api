package com.example.pokemonapi.commons

class StringFormatter {
    fun formatIDToThreeDigitsAndHash(id: String): String {
        return "#" + id.padStart(3, '0')
    }

    fun formatFirstLetterToUpperCase(str: String): String {
       return str.replaceFirstChar(Char::uppercase)
    }
}