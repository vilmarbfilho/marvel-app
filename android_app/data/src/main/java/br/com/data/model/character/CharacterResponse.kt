package br.com.data.model.character

import com.squareup.moshi.Json

data class CharacterResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "thumbnail")
    val thumbnail: CharacterImageResponse
)