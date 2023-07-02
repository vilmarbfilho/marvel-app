package br.com.marvelapp.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.marvelapp.characterlist.model.CharacterUi

abstract class CharacterListViewModel : ViewModel() {

    abstract val characters: LiveData<List<CharacterUi>>

    abstract fun loadCharacters()

    abstract fun openCharacterDetails(characterUi: CharacterUi)
}