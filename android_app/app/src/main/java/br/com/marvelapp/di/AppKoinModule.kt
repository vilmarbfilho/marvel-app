package br.com.marvelapp.di

import br.com.marvelapp.heroeslist.HeroesListViewModel
import br.com.marvelapp.heroeslist.HeroesListViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    // ViewModels
    viewModel<HeroesListViewModel> {
        HeroesListViewModelImpl()
    }
}

val koinModules = listOf(
    appKoinModule
)