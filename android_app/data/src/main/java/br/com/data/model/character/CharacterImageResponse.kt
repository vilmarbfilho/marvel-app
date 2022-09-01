package br.com.data.model.character

import com.squareup.moshi.Json

data class CharacterImageResponse(
    @Json(name = "path")
    val path: String,
    @Json(name = "extension")
    val extension: String
)