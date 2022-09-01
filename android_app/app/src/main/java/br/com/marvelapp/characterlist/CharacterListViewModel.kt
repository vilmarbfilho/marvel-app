package br.com.marvelapp.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.marvelapp.characterlist.model.HeroUi

abstract class CharacterListViewModel : ViewModel() {

    abstract val characters: LiveData<List<HeroUi>>

    abstract fun loadCharacters()

}