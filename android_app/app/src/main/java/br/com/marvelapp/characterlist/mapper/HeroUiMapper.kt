package br.com.marvelapp.characterlist.mapper

import br.com.marvelapp.characterlist.model.HeroUi
import br.com.domain.entity.Characters

fun Characters.toCharactersUi() = HeroUi(
    id = this.id,
    name = this.name,
    description = this.name,
    imageUrl = this.imageUrl
)