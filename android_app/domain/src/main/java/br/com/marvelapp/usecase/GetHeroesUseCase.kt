package br.com.marvelapp.usecase

import br.com.marvelapp.entity.Hero
import br.com.marvelapp.repository.HeroesRepository
import br.com.marvelapp.usecase.base.BaseUseCase

class GetHeroesUseCase(private val repository: HeroesRepository): BaseUseCase<Unit, List<Hero>>() {
    override suspend fun doWork(params: Unit): List<Hero> {
        return repository.getHeroes()
    }
}