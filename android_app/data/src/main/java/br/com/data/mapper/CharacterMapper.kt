package br.com.data.mapper

import br.com.data.model.character.CharacterImageResponse
import br.com.data.model.character.CharacterResponse
import br.com.marvelapp.entity.Characters

fun CharacterResponse.toCharacters() = Characters(
    id = this.id,
    name = this.name,
    description = this.name,
    imageUrl = this.thumbnail.toImageUrl()
)

fun CharacterImageResponse.toImageUrl() = this.url + this.ext