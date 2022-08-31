package br.com.marvelapp.usecase

import br.com.marvelapp.entity.Characters
import br.com.marvelapp.repository.MarvelRepository
import br.com.marvelapp.usecase.base.BaseUseCase

class GetHeroesUseCase(private val repository: MarvelRepository): BaseUseCase<Unit, List<Characters>>() {
    override suspend fun doWork(params: Unit): List<Characters> {
        return repository.getCharacters()
    }
}