package br.com.data.repository

import br.com.data.service.MarvelService
import br.com.marvelapp.entity.Hero
import br.com.marvelapp.repository.HeroesRepository

class HeroesRepositoryImpl(private val service: MarvelService): HeroesRepository {
    override suspend fun getHeroes(): List<Hero> {
        TODO("Not yet implemented")
    }
}