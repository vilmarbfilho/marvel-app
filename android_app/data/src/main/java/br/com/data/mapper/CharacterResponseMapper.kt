package br.com.data.mapper

import br.com.data.model.character.CharacterImageResponse
import br.com.data.model.character.CharacterResponse
import br.com.domain.entity.Character

fun CharacterResponse.toCharacters() = Character(
    id = id,
    name = name,
    description = name,
    imageUrl = thumbnail.toImageUrl()
)

fun CharacterImageResponse.toImageUrl() = this.url + this.ext