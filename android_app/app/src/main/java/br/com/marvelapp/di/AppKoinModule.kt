package br.com.marvelapp.di

import br.com.data.di.dataKoinModule
import br.com.marvelapp.characterlist.CharacterListViewModel
import br.com.marvelapp.characterlist.CharacterListViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    // ViewModels
    viewModel<CharacterListViewModel> {
        CharacterListViewModelImpl(get())
    }
}

val koinModules = listOf(
    appKoinModule,
    dataKoinModule
)