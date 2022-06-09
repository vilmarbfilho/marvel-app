package br.com.marvelapp.usecase

import br.com.marvelapp.entity.Hero
import br.com.marvelapp.usecase.base.BaseUseCase

class GetHeroesUseCase: BaseUseCase<Unit, List<Hero>>() {
    override suspend fun doWork(params: Unit): List<Hero> {
        TODO("Not yet implemented")
    }
}