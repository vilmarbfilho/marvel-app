package br.com.marvelapp.characterlist.mapper

import br.com.marvelapp.characterlist.model.CharacterUi
import br.com.domain.entity.Character

fun Character.toCharactersUi() = CharacterUi(
    id = this.id,
    name = this.name,
    description = this.name,
    imageUrl = this.imageUrl
)