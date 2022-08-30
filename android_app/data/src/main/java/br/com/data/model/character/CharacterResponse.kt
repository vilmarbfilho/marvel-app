package br.com.data.model.character

data class CharacterResponse(
    val id: Int,
    val name: String,
    val resultDescription: String,
    val thumbnail: CharacterImageResponse
)