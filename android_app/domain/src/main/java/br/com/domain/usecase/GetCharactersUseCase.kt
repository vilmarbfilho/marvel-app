package br.com.domain.usecase

import br.com.domain.entity.Characters
import br.com.domain.repository.MarvelRepository
import br.com.domain.usecase.base.BaseUseCase

class GetCharactersUseCase(private val repository: MarvelRepository): BaseUseCase<Unit, List<Characters>>() {
    override suspend fun doWork(params: Unit): List<Characters> {
        return repository.getCharacters()
    }
}