package br.com.marvelapp.repository

import br.com.marvelapp.entity.Characters

interface HeroesRepository {

    suspend fun getCharacters():  List<Characters>

}