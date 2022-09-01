package br.com.data.repository

import br.com.data.mapper.toCharacters
import br.com.data.service.MarvelService
import br.com.domain.entity.Character
import br.com.domain.repository.MarvelRepository

class MarvelRepositoryImpl(private val service: MarvelService) : MarvelRepository {
    override suspend fun getCharacters(): List<Character> {
        val data = service.getCharacters().data
        return data.results.map {
            it.toCharacters()
        }
    }
}