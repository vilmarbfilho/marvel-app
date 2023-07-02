package br.com.marvelapp.characterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.marvelapp.characterlist.mapper.toCharactersUi
import br.com.marvelapp.characterlist.model.CharacterUi
import br.com.domain.entity.Character
import br.com.domain.usecase.GetCharactersUseCase
import br.com.marvelapp.router.AppRouter
import kotlinx.coroutines.launch

class CharacterListViewModelImpl(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val appRouter: AppRouter,
): CharacterListViewModel() {

    override val characters = MutableLiveData<List<CharacterUi>>()

    override fun loadCharacters() {
       viewModelScope.launch {
           val result = getCharactersUseCase.execute(Unit)
           result.handleResult(::successLoadCharacters, ::failureLoadCharacters)
       }
    }

    override fun openCharacterDetails(characterUi: CharacterUi) {
       appRouter.openDetail(characterUi)
    }

    private fun successLoadCharacters(list: List<Character>) {
        characters.value = list.map { it.toCharactersUi() }
    }

    private fun failureLoadCharacters() {
        // Do Something
    }
}