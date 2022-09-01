package br.com.marvelapp.di

import br.com.data.di.dataKoinModule
import br.com.domain.constants.PRIVATE_KEY
import br.com.domain.constants.PUBLIC_KEY
import br.com.marvelapp.characterlist.CharacterListViewModel
import br.com.marvelapp.characterlist.CharacterListViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appKoinModule = module {
    // ViewModels
    viewModel<CharacterListViewModel> {
        CharacterListViewModelImpl(get())
    }

    // Keys
    single(named(PUBLIC_KEY)) { "Add a marvel public key" }
    single(named(PRIVATE_KEY)) { "Add a marvel private key" }
}

val koinModules = listOf(
    appKoinModule,
    dataKoinModule
)