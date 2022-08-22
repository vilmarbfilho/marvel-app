package br.com.data.di

import br.com.data.repository.HeroesRepositoryImpl
import br.com.marvelapp.repository.HeroesRepository
import org.koin.dsl.module

val dataKoinModule = module {

    factory<HeroesRepository> {
        HeroesRepositoryImpl(get())
    }
}