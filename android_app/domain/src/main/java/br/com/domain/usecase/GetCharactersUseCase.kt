package br.com.domain.usecase

import br.com.domain.entity.Character
import br.com.domain.repository.MarvelRepository
import br.com.domain.usecase.base.BaseUseCase

class GetCharactersUseCase(private val repository: MarvelRepository): BaseUseCase<Unit, List<Character>>() {
    override suspend fun doWork(params: Unit): List<Character> {
        return repository.getCharacters()
    }
}