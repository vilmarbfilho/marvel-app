package br.com.marvelapp.di

import androidx.appcompat.app.AppCompatActivity
import br.com.data.di.dataKoinModule
import br.com.domain.constants.PRIVATE_KEY
import br.com.domain.constants.PUBLIC_KEY
import br.com.domain.usecase.GetCharactersUseCase
import br.com.marvelapp.characterlist.CharacterListViewModel
import br.com.marvelapp.characterlist.CharacterListViewModelImpl
import br.com.marvelapp.router.AppRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appKoinModule = module {
    // ViewModels
    viewModel<CharacterListViewModel> { (activity: AppCompatActivity) ->
        CharacterListViewModelImpl(get(), get { parametersOf(activity)})
    }

    factory { (activity: AppCompatActivity) -> AppRouter(activity) }

    // Use case
    factory { GetCharactersUseCase(get()) }

    // Keys
    single(named(PUBLIC_KEY)) { "2f0be02d2438da8ea160cc70b7213d2d" }
    single(named(PRIVATE_KEY)) { "4e8a41aae4a96dcdd26cc26a5fdd42aba3ba6352" }
}

val koinModules = listOf(
    appKoinModule,
    dataKoinModule
)