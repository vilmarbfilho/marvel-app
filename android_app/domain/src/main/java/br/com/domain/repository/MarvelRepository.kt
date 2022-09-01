package br.com.domain.repository

import br.com.domain.entity.Character

interface MarvelRepository {

    suspend fun getCharacters():  List<Character>

}