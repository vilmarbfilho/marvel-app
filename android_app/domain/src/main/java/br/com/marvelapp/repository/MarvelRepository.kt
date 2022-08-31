package br.com.marvelapp.repository

import br.com.marvelapp.entity.Characters

interface MarvelRepository {

    suspend fun getCharacters():  List<Characters>

}