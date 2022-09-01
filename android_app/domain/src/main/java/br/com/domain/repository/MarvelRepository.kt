package br.com.domain.repository

import br.com.domain.entity.Characters

interface MarvelRepository {

    suspend fun getCharacters():  List<Characters>

}