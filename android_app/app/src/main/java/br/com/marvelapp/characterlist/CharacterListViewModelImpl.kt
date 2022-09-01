package br.com.marvelapp.characterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.marvelapp.characterlist.mapper.toCharactersUi
import br.com.marvelapp.characterlist.model.HeroUi
import br.com.domain.entity.Characters
import br.com.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharacterListViewModelImpl(
    private val getCharactersUseCase: GetCharactersUseCase
): CharacterListViewModel() {

    override val characters = MutableLiveData<List<HeroUi>>()

    override fun loadCharacters() {
       viewModelScope.launch {
           val result = getCharactersUseCase.execute(Unit)
           result.handleResult(::successLoadCharacters, ::failureLoadCharacters)
       }
    }

    private fun successLoadCharacters(list: List<Characters>) {
        characters.value = list.map { it.toCharactersUi() }
    }

    private fun failureLoadCharacters() {
        // Do Something
    }
}