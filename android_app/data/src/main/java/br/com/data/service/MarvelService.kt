package br.com.data.service

import br.com.data.model.character.CharacterResponse

interface MarvelService {

    suspend fun getCharacters(): List<CharacterResponse>

}