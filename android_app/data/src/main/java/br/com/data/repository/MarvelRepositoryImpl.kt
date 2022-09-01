package br.com.data.repository

import br.com.data.mapper.toCharacters
import br.com.data.service.MarvelService
import br.com.marvelapp.entity.Characters
import br.com.marvelapp.repository.MarvelRepository

class MarvelRepositoryImpl(private val service: MarvelService) : MarvelRepository {
    override suspend fun getCharacters(): List<Characters> {
        val data = service.getCharacters().data
        return data.results.map {
            it.toCharacters()
        }
    }
}